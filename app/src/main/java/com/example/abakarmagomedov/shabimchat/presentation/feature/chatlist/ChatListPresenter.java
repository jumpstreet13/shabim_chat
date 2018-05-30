package com.example.abakarmagomedov.shabimchat.presentation.feature.chatlist;

import android.util.Log;

import com.example.abakarmagomedov.shabimchat.domain.interactor.ChatListInteractor;
import com.example.abakarmagomedov.shabimchat.presentation.base.BaseMvpPresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Abakar on 3/16/2018.
 */

public class ChatListPresenter extends BaseMvpPresenter<ChatListView> {

    private final ChatListInteractor chatListInteractor;

    @Inject
    public ChatListPresenter(ChatListInteractor chatListInteractor) {
        this.chatListInteractor = chatListInteractor;
    }

    public void getAllChats() {
        compositeDisposable.add(chatListInteractor.getAllChats()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(chatRoomEntities -> {
                    Log.d("Entities", chatRoomEntities.toString());
                    getView().allChatsLoaded(chatRoomEntities);
                }, throwable -> {
                    if (getView() != null) {
                        getView().showError(throwable.getMessage());
                    }
                }));
    }
}