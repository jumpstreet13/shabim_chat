package com.example.abakarmagomedov.shabimchat.data.repository

import android.os.Message
import com.example.abakarmagomedov.shabimchat.data.mapper.MessageMapper
import com.example.abakarmagomedov.shabimchat.data.model.ChatRoomModel
import com.example.abakarmagomedov.shabimchat.data.model.MessageModel
import com.example.abakarmagomedov.shabimchat.domain.entity.MessageEntity
import com.example.abakarmagomedov.shabimchat.domain.gateway.ChatRoomGateway
import io.reactivex.Observable
import io.realm.Realm
import io.realm.kotlin.where
import java.util.*
import javax.inject.Inject

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */
class ChatRoomRepository @Inject constructor(private val messageMapper: MessageMapper) : ChatRoomGateway {

    override fun getMessages(id: Int): Observable<List<MessageEntity>> {
        var chatRoomModel: ChatRoomModel? = null
        Realm.getDefaultInstance().use {
            val result = it.where(ChatRoomModel::class.java)
                    .equalTo("id", id)
                    .findFirst()
            chatRoomModel = it.copyFromRealm(result)
        }
        val messagesList = Collections.emptyList<MessageEntity>()
        return Observable.create {
            (chatRoomModel?.messages
                    ?: Collections.emptyList<MessageModel>()).mapTo(messagesList) { messageMapper.map(it) }
        }
    }
}