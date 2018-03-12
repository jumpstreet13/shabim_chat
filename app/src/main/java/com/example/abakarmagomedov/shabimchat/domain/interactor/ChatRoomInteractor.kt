package com.example.abakarmagomedov.shabimchat.domain.interactor

import com.example.abakarmagomedov.shabimchat.data.model.MessageModel
import com.example.abakarmagomedov.shabimchat.domain.entity.MessageEntity
import com.example.abakarmagomedov.shabimchat.domain.usecase.AddMessageUseCase
import com.example.abakarmagomedov.shabimchat.domain.usecase.GetMessagesUseCase
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */
class ChatRoomInteractor @Inject constructor(private val addMessageUseCase: AddMessageUseCase, private val getMessagesUseCase: GetMessagesUseCase) {

    fun getAllMessagesForRoom(id: Int): Observable<List<MessageEntity>> {
        return getMessagesUseCase.getMessagesForChatRoom(id)
    }

    fun addNewMessage(messageModel: MessageModel, chatId: Int): Completable {
        return addMessageUseCase.addMessage(messageModel, chatId)
    }

}