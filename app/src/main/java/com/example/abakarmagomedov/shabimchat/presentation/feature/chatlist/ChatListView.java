package com.example.abakarmagomedov.shabimchat.presentation.feature.chatlist;

import com.example.abakarmagomedov.shabimchat.domain.entity.ChatRoomEntity;
import com.example.abakarmagomedov.shabimchat.presentation.base.CanShowError;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import java.util.List;

/**
 * Created by Abakar on 3/16/2018.
 */

public interface ChatListView extends MvpView, CanShowError {
    void allChatsLoaded(List<ChatRoomEntity> chats);
}
