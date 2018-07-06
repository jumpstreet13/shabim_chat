package com.example.abakarmagomedov.shabimchat.presentation.feature.main.di

import com.example.abakarmagomedov.shabimchat.di.scope.PerFragment
import com.example.abakarmagomedov.shabimchat.presentation.feature.chatlist.ChatListFragment
import com.example.abakarmagomedov.shabimchat.presentation.feature.chatlist.di.ChatListModule
import com.example.abakarmagomedov.shabimchat.presentation.feature.chatroom.ChatRoomFragment
import com.example.abakarmagomedov.shabimchat.presentation.feature.chatroom.di.ChatRoomModule
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

/**
 * Created by abakarmagomedov on 12/03/2018 at project ShabimChat.
 */

@Module(includes = [AndroidInjectionModule::class])
interface MainBuilderModule {

    @ContributesAndroidInjector(modules = [ChatRoomModule::class])
    fun provideChatRoomFragment(): ChatRoomFragment

    @ContributesAndroidInjector(modules = [ChatListModule::class])
    fun provideChatListFragment(): ChatListFragment
}                             