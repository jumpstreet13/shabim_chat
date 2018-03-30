package com.example.abakarmagomedov.shabimchat.data.model;

import com.example.abakarmagomedov.shabimchat.domain.entity.UserEntity;
import com.example.abakarmagomedov.shabimchat.presentation.base.Message;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by abakarmagomedov on 13/03/2018 at project ShabimChat.
 */

public class AudioMessageModel extends RealmObject implements Message {

    @PrimaryKey
    private long id;
    private String pathToFile;
    private long createdAt;
    private boolean isSender;
    private String duration;

    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
