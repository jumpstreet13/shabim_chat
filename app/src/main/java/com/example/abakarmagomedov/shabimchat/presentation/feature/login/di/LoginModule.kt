package com.example.abakarmagomedov.shabimchat.presentation.feature.login.di

import android.app.Activity
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides

/**
 * Created by abakarmagomedov on 06/03/2018 at project ShabimChat.
 */

@Module
class LoginModule {

    @Provides
    fun provideFragmentManager(activity: AppCompatActivity): FragmentManager {
        return activity.supportFragmentManager;
    }
}