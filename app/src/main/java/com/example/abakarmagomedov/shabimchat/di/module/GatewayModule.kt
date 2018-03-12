package com.example.abakarmagomedov.shabimchat.di.module

import com.example.abakarmagomedov.shabimchat.data.repository.ChatRoomRepository
import com.example.abakarmagomedov.shabimchat.domain.gateway.ChatRoomGateway
import dagger.Binds
import dagger.Module

/**
 * Created by abakarmagomedov on 12/03/2018 at project ShabimChat.
 */
@Module
interface GatewayModule {
    @Binds
    fun provideChatRoomGateway(chatRoomRepository: ChatRoomRepository): ChatRoomGateway
}