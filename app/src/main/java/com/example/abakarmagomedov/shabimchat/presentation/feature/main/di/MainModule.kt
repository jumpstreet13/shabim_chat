package com.example.abakarmagomedov.shabimchat.presentation.feature.main.di

import com.example.abakarmagomedov.shabimchat.delegates.ErrorDialogDelegate
import com.example.abakarmagomedov.shabimchat.delegates.LoaderDialogDelegate
import com.example.abakarmagomedov.shabimchat.delegates.ToolbarTitleDelegate
import com.example.abakarmagomedov.shabimchat.di.scope.PerActivity
import com.example.abakarmagomedov.shabimchat.di.scope.PerFragment
import com.example.abakarmagomedov.shabimchat.presentation.base.BaseMvpFragment
import com.example.abakarmagomedov.shabimchat.presentation.feature.chatroom.ChatRoomFragment
import com.example.abakarmagomedov.shabimchat.presentation.feature.chatroom.di.ChatRoomModule
import com.example.abakarmagomedov.shabimchat.presentation.feature.main.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

/**
 * Created by abakarmagomedov on 12/03/2018 at project ShabimChat.
 */
@Module
class MainModule {

    @PerActivity
    @Provides
    internal fun loaderDialogDelegate(activity: MainActivity): LoaderDialogDelegate {
        return LoaderDialogDelegate(activity.supportFragmentManager)
    }

    @PerActivity
    @Provides
    internal fun errorDialogDelegate(activity: MainActivity): ErrorDialogDelegate {
        return ErrorDialogDelegate(activity.supportFragmentManager)
    }

    @PerActivity
    @Provides
    internal fun toolbarTitleDelegate(activity: MainActivity): ToolbarTitleDelegate {
        return ToolbarTitleDelegate(activity)
    }
}