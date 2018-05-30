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
    private Long messageTime;
    private String senderAvatar;
    private String recepientAvatar;
    private RealmList<MessageModel> messages;
    private RealmList<AudioMessageModel> audioMessageModels;

    public ChatRoomModel() {
    }

    public ChatRoomModel(long id, String recepientName, MessageModel messageModel, Long messageTime) {
        this.id = id;
        this.recepientName = recepientName;
        this.messageTime = messageTime;
        messages = new RealmList<>();
        messages.add(messageModel);
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
