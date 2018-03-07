package com.example.abakarmagomedov.shabimchat.presentation.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.text.Layout
import butterknife.ButterKnife
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 06/03/2018 at project ShabimChat.
 */
abstract class BaseMvpActivity<V : MvpView, P : MvpPresenter<V>> : MvpActivity<V, P>() {

    @Inject
    protected lateinit var shabimPresenter: P


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
        ButterKnife.bind(this)
    }

    override fun createPresenter(): P = shabimPresenter
    @LayoutRes
    abstract fun layoutRes(): Int

}