package com.example.abakarmagomedov.shabimchat.domain.entity;

/**
 * Created by abakarmagomedov on 18/02/2018 at project ShabimChat.
 */

public class ChatRoomEntity {

    private long id;
    private String recepientName;
    private MessageEntity messages;
    private Long messageTime;
    private String senderAvatar;
    private String recepientAvatar;

    public ChatRoomEntity() {
    }

    public ChatRoomEntity(long id, String recepientName, Long messageTime) {
        this.id = id;
        this.recepientName = recepientName;
        this.messageTime = messageTime;
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

    public MessageEntity getMessages() {
        return messages;
    }

    public void setMessages(MessageEntity messages) {
        this.messages = messages;
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
