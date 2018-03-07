package com.example.abakarmagomedov.shabimchat

import com.example.abakarmagomedov.shabimchat.di.DaggerAppComponent
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.realm.Realm
import io.realm.RealmConfiguration


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