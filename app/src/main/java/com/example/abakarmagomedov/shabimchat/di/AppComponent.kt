package com.example.abakarmagomedov.shabimchat.di

import com.example.abakarmagomedov.shabimchat.App
import com.example.abakarmagomedov.shabimchat.di.module.AppModule
import com.example.abakarmagomedov.shabimchat.di.module.BuilderModule
import com.example.abakarmagomedov.shabimchat.di.module.NetworkModule
import com.example.abakarmagomedov.shabimchat.di.module.RxModule
import com.example.abakarmagomedov.shabimchat.di.scope.PerApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by abakarmagomedov on 06/03/2018 at project ShabimChat.
 */
@PerApplication
@Component(modules = [(AppModule::class), (RxModule::class), (NetworkModule::class), (BuilderModule::class), (AndroidSupportInjectionModule::class)])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}