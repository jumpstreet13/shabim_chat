package com.example.abakarmagomedov.shabimchat.entity;

import com.example.abakarmagomedov.shabimchat.ChatEntityMarker;

/**
 * Created by abakarmagomedov on 05/03/2018 at project ShabimChat.
 */

public class AudioMessage implements ChatEntityMarker {
    private String pathToFile;
    private User sender;
    private long createdAt;
    private boolean isSender;

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
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

    @Override
    public boolean isFromSender() {
        return isSender;
    }
}
