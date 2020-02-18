package com.example.spacexdata.presenter

import com.example.spacexdata.network.ClientInstance
import com.example.spacexdata.view.SpacexDataContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class SpacexPresenter(private var view: SpacexDataContract.SpacexView?) :
    SpacexDataContract.SpacexPresenter {
    private val call = ClientInstance.getClient().getSpacexData()
    private val compositeDisposable = CompositeDisposable()

    override fun getAllData() {
        compositeDisposable.add(
            call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ dataList -> view?.showData(dataList) },
                    { errorMessage -> view?.showError(errorMessage.message.toString()) })
        )
    }

    override fun getActiveData() {
        compositeDisposable.add(
            call.subscribeOn(Schedulers.io())
                .map { i->i.filter { i->i.active } }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ dataList -> view?.showData(dataList) },
                    { errorMessage -> view?.showError(errorMessage.message.toString()) })
        )
    }

    override fun onDestroyCalled() {
        compositeDisposable.clear()
        view = null
    }
}