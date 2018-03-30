package com.example.abakarmagomedov.shabimchat.data.model;

import com.example.abakarmagomedov.shabimchat.domain.entity.UserEntity;
import com.example.abakarmagomedov.shabimchat.presentation.base.Message;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */

public class MessageModel extends RealmObject implements Message {

    @PrimaryKey
    private long id;
    private long chatId;
    private String message;
    //private UserEntity sender;
    private long createdAt;
    private boolean isSender;

    public MessageModel() {
    }

    public MessageModel(long id, long chatId, String message, long createdAt, boolean isSender) {
        this.id = id;
        this.chatId = chatId;
        this.message = message;
       // this.sender = sender;
        this.createdAt = createdAt;
        this.isSender = isSender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

  /*  public UserEntity getSender() {
        return sender;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }*/

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isSender() {
        return isSender;
    }

    public void setSender(boolean sender) {
        isSender = sender;
    }
}
