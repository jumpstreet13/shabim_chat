package com.example.abakarmagomedov.shabimchat.presentation.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.text.Layout
import butterknife.ButterKnife
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 06/03/2018 at project ShabimChat.
 */
abstract class BaseMvpActivity<V : MvpView, P : MvpPresenter<V>> : MvpActivity<V, P>(), HasSupportFragmentInjector {

    @Inject
    protected lateinit var shabimPresenter: P

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
        ButterKnife.bind(this)
    }

    override fun createPresenter(): P = shabimPresenter
    @LayoutRes
    abstract fun layoutRes(): Int

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}