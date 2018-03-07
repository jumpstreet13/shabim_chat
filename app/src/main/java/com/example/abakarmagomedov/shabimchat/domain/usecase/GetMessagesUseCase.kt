package com.example.abakarmagomedov.shabimchat.domain.usecase

import com.example.abakarmagomedov.shabimchat.domain.entity.MessageEntity
import com.example.abakarmagomedov.shabimchat.domain.gateway.ChatRoomGateway
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */
class GetMessagesUseCase @Inject constructor(private val chatRoomGateway: ChatRoomGateway) {

    fun getMessagesForChatRoom(chatRoomId: Int): Observable<List<MessageEntity>> {
        return chatRoomGateway.getMessages(chatRoomId)
    }
}