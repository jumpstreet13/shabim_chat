package com.example.abakarmagomedov.shabimchat

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import com.example.abakarmagomedov.shabimchat.di.DaggerAppComponent
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.realm.Realm
import io.realm.RealmConfiguration
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


/**
 * Created by abakarmagomedov on 06/03/2018 at project ShabimChat.
 */
class App : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        Realm.init(this)
        val config = RealmConfiguration.Builder()
                .name("shabim.realm")
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(config)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.builder().create(this)
}