package com.example.abakarmagomedov.shabimchat.presentation.feature.chatroom

import com.example.abakarmagomedov.shabimchat.domain.entity.MessageEntity
import com.example.abakarmagomedov.shabimchat.presentation.base.CanShowError
import com.hannesdorfmann.mosby3.mvp.MvpView

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */
interface ChatRoomView : MvpView, CanShowError {
    fun loadedMessages(messages: List<MessageEntity>);
}