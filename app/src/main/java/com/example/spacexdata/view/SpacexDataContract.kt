package com.example.spacexdata.view

import com.example.spacexdata.model.SpacexDataResponse

interface SpacexDataContract {
    interface SpacexView {
        fun showData(spacexDataResponseList: List<SpacexDataResponse>)
        fun showError(errorMessage:String)
    }

    interface SpacexPresenter{
        fun getAllData()
        fun getActiveData()
        fun onDestroyCalled()
    }

}