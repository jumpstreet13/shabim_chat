package com.example.abakarmagomedov.shabimchat.presentation.base

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.abakarmagomedov.shabimchat.R
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import java.util.*

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */
abstract class ToolbarActivity<V : MvpView, P : MvpPresenter<V>> : BaseMvpActivity<V, P>(), ToolbarTitleManager {

    private var titlesStack: Stack<String>? = null

    override fun changeTitle(title: String) {
        titlesStack?.push(title)
        setTitle(title)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        titlesStack = Stack()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (titlesStack?.size ?: 0 > 1) {
            titlesStack?.pop()
            title = titlesStack?.peek()
        }
    }

    protected fun setToolbar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                toolbar.setNavigationOnClickListener { onBackPressed() }
            } else {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
            }
        }
    }

    private fun setTitle(title: String) {
        if (supportActionBar != null) {
            supportActionBar?.title = title
        }
    }
}