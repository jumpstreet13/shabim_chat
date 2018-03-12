package com.example.abakarmagomedov.shabimchat.domain.usecase

import com.example.abakarmagomedov.shabimchat.data.model.MessageModel
import com.example.abakarmagomedov.shabimchat.domain.gateway.ChatRoomGateway
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */
class AddMessageUseCase @Inject constructor(private val chatRoomGateway: ChatRoomGateway) {

    fun addMessage(messageModel: MessageModel, chatId: Int): Completable {
        return chatRoomGateway.addMessage(messageModel, chatId)
    }
}