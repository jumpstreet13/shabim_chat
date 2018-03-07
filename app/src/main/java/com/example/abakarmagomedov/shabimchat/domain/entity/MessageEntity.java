package com.example.abakarmagomedov.shabimchat.domain.entity;

/**
 * Created by abakarmagomedov on 21/02/2018 at project ShabimChat.
 */

public class MessageEntity implements ChatEntityMarker {

    private String message;
    private UserEntity sender;
    private long createdAt;
    private boolean isSender;

    public MessageEntity() {
    }

    public MessageEntity(String message, long createdAt) {
        this.message = message;
        this.createdAt = createdAt;
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
