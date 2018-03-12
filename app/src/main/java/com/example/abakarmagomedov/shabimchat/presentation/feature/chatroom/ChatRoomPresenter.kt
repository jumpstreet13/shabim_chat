package com.example.abakarmagomedov.shabimchat.presentation.feature.chatroom

import com.example.abakarmagomedov.shabimchat.data.mapper.MessageMapper
import com.example.abakarmagomedov.shabimchat.domain.entity.MessageEntity
import com.example.abakarmagomedov.shabimchat.domain.interactor.ChatRoomInteractor
import com.example.abakarmagomedov.shabimchat.presentation.base.BaseMvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */
class ChatRoomPresenter @Inject constructor(private val chatRoomInteractor: ChatRoomInteractor,
                                            private val mapper: MessageMapper) : BaseMvpPresenter<ChatRoomView>() {

    public fun getAllMessages(id: Int) {
        compositeDisposable.add(chatRoomInteractor.getAllMessagesForRoom(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.loadedMessages(it.asReversed())
                }, { t: Throwable? -> t?.message?.let { view?.showError(it) } }))
    }

    public fun sendMessage(messageEntity: MessageEntity, chatId: Int) {
        chatRoomInteractor.addNewMessage(mapper.map(messageEntity), chatId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ view?.messageSentSuccessfully(messageEntity) }, { t: Throwable? ->
                    view?.showError(t?.message ?: "unknown error")
                    view?.messageNotSent(messageEntity)
                })
    }
}