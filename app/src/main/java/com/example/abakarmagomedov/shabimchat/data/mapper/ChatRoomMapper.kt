package com.example.abakarmagomedov.shabimchat.data.mapper

import com.example.abakarmagomedov.shabimchat.data.model.ChatRoomModel
import com.example.abakarmagomedov.shabimchat.domain.entity.ChatRoomEntity
import com.example.abakarmagomedov.shabimchat.domain.entity.MessageEntity
import java.util.*
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 12/03/2018 at project ShabimChat.
 */
class ChatRoomMapper @Inject constructor(private val messageMapper: MessageMapper) {

    fun map(from: ChatRoomModel): ChatRoomEntity {
        val chatRoomEntity = ChatRoomEntity()
        chatRoomEntity.id = from.id
        chatRoomEntity.messages.addAll(messageMapper.mapModel(from.messages.toList()))
        chatRoomEntity.messageTime = from.messageTime
        chatRoomEntity.recepientName = from.recepientName
        return chatRoomEntity
    }

    fun map(from: ChatRoomEntity): ChatRoomModel {
        val chatRoomModel = ChatRoomModel()
        chatRoomModel.id = from.id
        chatRoomModel.messages.addAll(messageMapper.map(from.messages.toList()))
        chatRoomModel.messageTime = from.messageTime
        chatRoomModel.recepientName = from.recepientName
        return chatRoomModel
    }

    fun map(from: List<ChatRoomModel>): List<ChatRoomEntity> {
        val chatList = ArrayList<ChatRoomEntity>()
        from.mapTo(chatList) { map(it) }
        return chatList
    }
}