package com.example.abakarmagomedov.shabimchat.presentation.base

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */
abstract class BaseMvpPresenter<V : MvpView> : MvpBasePresenter<V>() {

    protected lateinit var compositeDisposable: CompositeDisposable

    override fun attachView(view: V) {
        super.attachView(view)
        compositeDisposable = CompositeDisposable()
    }

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
        compositeDisposable.dispose()
    }
}