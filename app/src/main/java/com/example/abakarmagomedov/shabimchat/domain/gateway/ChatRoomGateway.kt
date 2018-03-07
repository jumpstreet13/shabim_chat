package com.example.abakarmagomedov.shabimchat.domain.gateway

import com.example.abakarmagomedov.shabimchat.domain.entity.MessageEntity
import io.reactivex.Observable

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */
interface ChatRoomGateway {
    fun getMessages(id: Int): Observable<List<MessageEntity>>
}