package com.example.abakarmagomedov.shabimchat.Entity;

/**
 * Created by abakarmagomedov on 21/02/2018 at project ShabimChat.
 */

public class Message {

    private String message;
    private User sender;
    private long createdAt;
    private boolean isSender;

    public Message() {
    }

    public Message(String message, long createdAt) {
        this.message = message;
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
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
}
