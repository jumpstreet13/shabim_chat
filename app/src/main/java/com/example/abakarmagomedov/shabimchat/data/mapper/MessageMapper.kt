package com.example.abakarmagomedov.shabimchat.data.mapper

import android.os.Message
import com.example.abakarmagomedov.shabimchat.data.model.MessageModel
import com.example.abakarmagomedov.shabimchat.domain.entity.MessageEntity
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */
class MessageMapper @Inject constructor() {

    fun map(from: MessageModel): MessageEntity {
        val messageEntity = MessageEntity()
        messageEntity.id = from.id
        messageEntity.message = from.message
        //messageEntity.sender = from.sender
        messageEntity.createdAt = from.createdAt
        messageEntity.isSender = from.isSender
        messageEntity.chatId = from.chatId
        return messageEntity
    }

    fun map(from: MessageEntity): MessageModel {
        val messageModel = MessageModel()
        messageModel.id = from.id
        messageModel.message = from.message
        //messageModel.sender = from.sender
        messageModel.createdAt = from.createdAt
        messageModel.isSender = from.isSender
        messageModel.chatId = from.chatId
        return messageModel
    }

}