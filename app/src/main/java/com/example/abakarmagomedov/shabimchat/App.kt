package com.example.abakarmagomedov.shabimchat

import com.example.abakarmagomedov.shabimchat.di.DaggerAppComponent
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by abakarmagomedov on 06/03/2018 at project ShabimChat.
 */
class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.builder().create(this)
}