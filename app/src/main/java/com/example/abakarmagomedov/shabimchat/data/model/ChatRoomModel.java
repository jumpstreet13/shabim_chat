package com.example.abakarmagomedov.shabimchat.data.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */

public class ChatRoomModel extends RealmObject {

    @PrimaryKey
    private long id;

    private String recepientName;
    private String messageText;
    private Long messageTime;
    private String senderAvatar;
    private String recepientAvatar;
    private RealmList<MessageModel> messages;

    public ChatRoomModel(String recepientName, String messageText, Long messageTime) {
        this.recepientName = recepientName;
        this.messageText = messageText;
        this.messageTime = messageTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecepientName() {
        return recepientName;
    }

    public void setRecepientName(String recepientName) {
        this.recepientName = recepientName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Long messageTime) {
        this.messageTime = messageTime;
    }

    public String getSenderAvatar() {
        return senderAvatar;
    }

    public void setSenderAvatar(String senderAvatar) {
        this.senderAvatar = senderAvatar;
    }

    public String getRecepientAvatar() {
        return recepientAvatar;
    }

    public void setRecepientAvatar(String recepientAvatar) {
        this.recepientAvatar = recepientAvatar;
    }

    public RealmList<MessageModel> getMessages() {
        return messages;
    }

    public void setMessages(RealmList<MessageModel> messages) {
        this.messages = messages;
    }
}
