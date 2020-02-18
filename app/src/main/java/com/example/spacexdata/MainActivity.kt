package com.example.spacexdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacexdata.model.SpacexDataResponse
import com.example.spacexdata.presenter.SpacexPresenter
import com.example.spacexdata.recycle_view.SpacexDataAdapter
import com.example.spacexdata.view.SpacexDataContract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SpacexDataContract.SpacexView {
    private lateinit var presenter: SpacexDataContract.SpacexPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = SpacexPresenter(this)
        presenter.getAllData()
    }

    override fun showData(spacexDataResponseList: List<SpacexDataResponse>) {
        rv_spacex_data.layoutManager = LinearLayoutManager(this)
        val spacexDataAdapter = SpacexDataAdapter(spacexDataResponseList)
        rv_spacex_data.adapter = spacexDataAdapter
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }

    fun onRadioButtonClicked(view: View) {
        if(view is RadioButton){
            val checked = view.isChecked

            when(view.id){
                R.id.rb_all->
                    if(checked){
                        presenter.getAllData()
                    }
                R.id.rb_active->
                    if (checked){
                        presenter.getActiveData()
                    }
            }
        }
    }
}
