package com.example.abakarmagomedov.shabimchat.di.module

import com.example.abakarmagomedov.shabimchat.presentation.feature.login.LoginActivity
import com.example.abakarmagomedov.shabimchat.di.scope.PerActivity
import com.example.abakarmagomedov.shabimchat.presentation.feature.login.di.LoginModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by abakarmagomedov on 06/03/2018 at project ShabimChat.
 */

@Module
interface BuilderModule {
    @PerActivity
    @ContributesAndroidInjector(modules = [(LoginModule::class)])
    fun provideLoginFactory(): LoginActivity
}