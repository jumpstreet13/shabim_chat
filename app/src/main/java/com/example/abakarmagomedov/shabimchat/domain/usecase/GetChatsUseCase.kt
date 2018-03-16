package com.example.abakarmagomedov.shabimchat.domain.usecase

import com.example.abakarmagomedov.shabimchat.domain.entity.ChatRoomEntity
import com.example.abakarmagomedov.shabimchat.domain.gateway.ChatRoomGateway
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Abakar on 3/16/2018.
 */
class GetChatsUseCase @Inject constructor(private val chatRoomGateway: ChatRoomGateway) {

    public fun getAllChats(): Single<List<ChatRoomEntity>> {
        return chatRoomGateway.getAllChats()
    }
}