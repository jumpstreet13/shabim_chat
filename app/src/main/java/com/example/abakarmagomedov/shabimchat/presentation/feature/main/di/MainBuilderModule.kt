package com.example.abakarmagomedov.shabimchat.presentation.feature.main.di

import com.example.abakarmagomedov.shabimchat.di.scope.PerFragment
import com.example.abakarmagomedov.shabimchat.presentation.feature.chatroom.ChatRoomFragment
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

/**
 * Created by abakarmagomedov on 12/03/2018 at project ShabimChat.
 */

@Module(includes = [AndroidInjectionModule::class])
interface MainBuilderModule {
    @PerFragment
    @ContributesAndroidInjector()
    fun provideChatRoomFragment(): ChatRoomFragment
}