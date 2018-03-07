package com.example.abakarmagomedov.shabimchat.domain.entity;

/**
 * Created by abakarmagomedov on 21/02/2018 at project ShabimChat.
 */

public class MessageEntity implements ChatEntityMarker {

    private long id;
    private String message;
    private long chatId;
    private UserEntity sender;
    private long createdAt;
    private boolean isSender;

    public MessageEntity() {
    }

    public MessageEntity(long id, String message, long chatId, UserEntity sender, long createdAt, boolean isSender) {
        this.id = id;
        this.message = message;
        this.chatId = chatId;
        this.sender = sender;
        this.createdAt = createdAt;
        this.isSender = isSender;
    }

    public MessageEntity(String message, long createdAt, long chatId) {
        this.message = message;
        this.createdAt = createdAt;
        this.chatId = chatId;
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

    public UserEntity getSender() {
        return sender;
    }

    public void setSender(UserEntity sender) {
        this.sender = sender;
    }

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

    @Override
    public boolean isFromSender() {
        return isSender;
    }
}
