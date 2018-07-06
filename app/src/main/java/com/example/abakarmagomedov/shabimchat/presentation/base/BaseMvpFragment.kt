package com.example.abakarmagomedov.shabimchat.presentation.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import com.example.abakarmagomedov.shabimchat.delegates.ErrorDialogDelegate
import com.example.abakarmagomedov.shabimchat.delegates.ToolbarTitleDelegate
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */
abstract class BaseMvpFragment<V : MvpView, P : MvpPresenter<V>> : MvpFragment<V, P>() {

    @Inject
    protected lateinit var shabimPresenter: P

    @Inject
    protected lateinit var toolbarTitleDelegate: ToolbarTitleDelegate

    @Inject
    protected lateinit var errorDialogDelegate: ErrorDialogDelegate

    private lateinit var unbinder: Unbinder

    override fun createPresenter(): P = shabimPresenter

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder.unbind()
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(layoutRes(), container, false)
        unbinder = ButterKnife.bind(this, view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    @LayoutRes
    protected abstract fun layoutRes(): Int

    protected abstract fun initUi()

    protected fun changeTitle(title: String) {
        toolbarTitleDelegate.changeTitle(title)
    }
}