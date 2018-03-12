package com.example.abakarmagomedov.shabimchat.di.module

import com.example.abakarmagomedov.shabimchat.presentation.feature.login.LoginActivity
import com.example.abakarmagomedov.shabimchat.di.scope.PerActivity
import com.example.abakarmagomedov.shabimchat.presentation.feature.login.di.LoginModule
import com.example.abakarmagomedov.shabimchat.presentation.feature.main.MainActivity
import com.example.abakarmagomedov.shabimchat.presentation.feature.main.di.MainBuilderModule
import com.example.abakarmagomedov.shabimchat.presentation.feature.main.di.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by abakarmagomedov on 06/03/2018 at project ShabimChat.
 */

@Module
interface BuilderModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [(LoginModule::class)])
    fun provideLoginInjector(): LoginActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [MainModule::class, MainBuilderModule::class])
    fun provideMainInjector(): MainActivity
}