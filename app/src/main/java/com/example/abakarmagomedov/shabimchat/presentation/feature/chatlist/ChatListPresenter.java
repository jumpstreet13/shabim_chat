package com.example.abakarmagomedov.shabimchat.presentation.feature.chatlist;

import com.example.abakarmagomedov.shabimchat.domain.interactor.ChatListInteractor;
import com.example.abakarmagomedov.shabimchat.presentation.base.BaseMvpPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Abakar on 3/16/2018.
 */

public class ChatListPresenter extends BaseMvpPresenter<ChatListView> {

    private final ChatListInteractor chatListInteractor;

    public ChatListPresenter(ChatListInteractor chatListInteractor) {
        this.chatListInteractor = chatListInteractor;
    }

    public void getAllChats() {
        chatListInteractor.getAllChats()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(chatRoomEntities -> {
                    if (getView() != null) {
                        getView().allChatsLoaded(chatRoomEntities);
                    }
                }, throwable -> {
                    if (getView() != null) {
                        getView().showError(throwable.getMessage());
                    }
                });
    }
}