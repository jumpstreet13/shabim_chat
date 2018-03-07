package com.example.abakarmagomedov.shabimchat.data.model;

import com.example.abakarmagomedov.shabimchat.domain.entity.UserEntity;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */

public class MessageModel extends RealmObject {

    @PrimaryKey
    private long id;

    private long chatId;
    private String pathToFile;
    private UserEntity sender;
    private long createdAt;
    private boolean isSender;

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
}
