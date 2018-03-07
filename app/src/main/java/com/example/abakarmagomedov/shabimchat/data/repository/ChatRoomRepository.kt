package com.example.abakarmagomedov.shabimchat.data.repository

import android.os.Message
import com.example.abakarmagomedov.shabimchat.data.model.ChatRoomModel
import com.example.abakarmagomedov.shabimchat.data.model.MessageModel
import com.example.abakarmagomedov.shabimchat.domain.entity.MessageEntity
import com.example.abakarmagomedov.shabimchat.domain.gateway.ChatRoomGateway
import io.reactivex.Observable
import io.realm.Realm
import io.realm.kotlin.where
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */
class ChatRoomRepository @Inject constructor() : ChatRoomGateway {

    override fun getMessages(id: Int): Observable<List<MessageEntity>> {
        var messages: List<MessageEntity>
        var chatRoomModel: ChatRoomModel? = null
        Realm.getDefaultInstance().use {
            val result = it.where(ChatRoomModel::class.java)
                    .equalTo("id", id)
                    .findFirst()
            chatRoomModel = it.copyFromRealm(result)
        }
        return Observable.create { chatRoomModel?.messages }
    }
}