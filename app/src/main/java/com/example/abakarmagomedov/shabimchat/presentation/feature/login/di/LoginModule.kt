package com.example.abakarmagomedov.shabimchat.presentation.feature.login.di

import android.app.Activity
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.example.abakarmagomedov.shabimchat.delegates.ErrorDialogDelegate
import com.example.abakarmagomedov.shabimchat.di.scope.PerActivity
import com.example.abakarmagomedov.shabimchat.presentation.feature.login.LoginActivity
import dagger.Module
import dagger.Provides

/**
 * Created by abakarmagomedov on 06/03/2018 at project ShabimChat.
 */

@Module
class LoginModule {

    @Provides
    @PerActivity
    fun provideFragmentManager(activity: LoginActivity): FragmentManager {
        return activity.supportFragmentManager;
    }

    @Provides
    @PerActivity
    fun provideErrorDialogDelegate(activity: LoginActivity): ErrorDialogDelegate {
        return ErrorDialogDelegate(activity.supportFragmentManager)
    }
}