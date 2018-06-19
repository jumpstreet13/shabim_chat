package com.example.abakarmagomedov.shabimchat.domain.interactor

import com.example.abakarmagomedov.shabimchat.domain.entity.ChatRoomEntity
import com.example.abakarmagomedov.shabimchat.domain.usecase.GetChatsUseCase
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Abakar on 3/16/2018.
 */
class ChatListInteractor @Inject constructor(private val getChatsUseCase: GetChatsUseCase) {

    fun getAllChats(): Single<List<ChatRoomEntity>> {
        return getChatsUseCase.getAllChats()
    }
}