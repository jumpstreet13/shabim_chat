package com.example.abakarmagomedov.shabimchat.data.repository

import android.os.Message
import com.example.abakarmagomedov.shabimchat.data.mapper.MessageMapper
import com.example.abakarmagomedov.shabimchat.data.model.ChatRoomModel
import com.example.abakarmagomedov.shabimchat.data.model.MessageModel
import com.example.abakarmagomedov.shabimchat.domain.entity.MessageEntity
import com.example.abakarmagomedov.shabimchat.domain.gateway.ChatRoomGateway
import io.reactivex.Completable
import io.reactivex.Observable
import io.realm.Realm
import io.realm.kotlin.where
import java.util.*
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */
class ChatRoomRepository @Inject constructor(private val messageMapper: MessageMapper) : ChatRoomGateway {

    override fun addMessage(messageModel: MessageModel, chatId: Int): Completable {
        return Completable.fromAction {
            Realm.getDefaultInstance().use {
                it.executeTransaction(Realm.Transaction {
                    val result = it.where(ChatRoomModel::class.java).equalTo("id", chatId)
                            .findFirst()
                    val chatRoomModel = it.copyFromRealm(result)
                    chatRoomModel?.messages?.add(messageModel)
                    it.insertOrUpdate(chatRoomModel)
                })
            }
        }
    }

    override fun getMessages(id: Int): Observable<List<MessageEntity>> {
        var chatRoomModel: ChatRoomModel? = null
        Realm.getDefaultInstance().use {
            val result = it.where(ChatRoomModel::class.java)
                    .equalTo("id", id)
                    .findFirst()
            chatRoomModel = it.copyFromRealm(result)
        }
        val messagesList = chatRoomModel?.messages
        return Observable.just(messagesList?.toList()?.let { messageMapper.mapModel(it) })
    }
}