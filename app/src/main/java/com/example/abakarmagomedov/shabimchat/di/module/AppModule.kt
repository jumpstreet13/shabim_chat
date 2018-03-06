package com.example.abakarmagomedov.shabimchat.di.module

import android.content.Context
import com.example.abakarmagomedov.shabimchat.App
import com.example.abakarmagomedov.shabimchat.di.scope.PerApplication
import dagger.Module
import dagger.Provides

/**
 * Created by abakarmagomedov on 06/03/2018 at project ShabimChat.
 */
@Module
class AppModule {

    @PerApplication
    @Provides
    fun provideContext(application: App): Context = application

    //@PerApplication
    //@Provides
    //fun provideCicerone(): Cicerone<Router> = Cicerone.create()
//
    //@PerApplication
    //@Provides
    //fun provideNavigatorHolder(cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder
//
    //@PerApplication
    //@Provides
    //fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router
}