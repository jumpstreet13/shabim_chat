package com.example.abakarmagomedov.shabimchat.domain.entity;

import com.example.abakarmagomedov.shabimchat.presentation.base.Message;

/**
 * Created by abakarmagomedov on 05/03/2018 at project ShabimChat.
 */

public class AudioMessageEntity implements ChatEntityMarker, Message {
    private String pathToFile;
    private UserEntity sender;
    private long createdAt;
    private boolean isSender;
    private String duration;

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public boolean isFromSender() {
        return isSender;
    }
}
