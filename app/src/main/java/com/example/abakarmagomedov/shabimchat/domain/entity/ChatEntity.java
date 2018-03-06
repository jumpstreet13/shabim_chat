package com.example.abakarmagomedov.shabimchat.domain.entity;

/**
 * Created by abakarmagomedov on 18/02/2018 at project ShabimChat.
 */

public class ChatEntity {

    private int id;
    private String recepientName;
    private String messageText;
    private Long messageTime;
    private String senderAvatar;
    private String recepientAvatar;

    public ChatEntity(String recepientName, String messageText, Long messageTime) {
        this.recepientName = recepientName;
        this.messageText = messageText;
        this.messageTime = messageTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
