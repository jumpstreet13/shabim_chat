package com.example.abakarmagomedov.shabimchat.presentation.feature.chatlist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abakarmagomedov.shabimchat.data.model.MessageModel;
import com.example.abakarmagomedov.shabimchat.presentation.base.BaseMvpFragment;
import com.example.abakarmagomedov.shabimchat.presentation.feature.chatlist.adapter.ChatAdapter;
import com.example.abakarmagomedov.shabimchat.R;
import com.example.abakarmagomedov.shabimchat.data.model.ChatRoomModel;
import com.example.abakarmagomedov.shabimchat.domain.entity.ChatRoomEntity;
import com.example.abakarmagomedov.shabimchat.managers.SharedPrefManager;
import com.example.abakarmagomedov.shabimchat.presentation.feature.main.MainActivity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import butterknife.BindView;
import io.realm.Realm;

public class ChatListFragment extends BaseMvpFragment<ChatListView, ChatListPresenter> implements ChatListView, ChatAdapter.ChatClickListener {

    @BindView(R.id.chats_recycler_view)
    RecyclerView recyclerView;
    private ChatClickedListener listener;

    public interface ChatClickedListener {
        void chatRoomClicked(int chatId);
    }

    public ChatListFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ChatListFragment newInstance() {
        ChatListFragment fragment = new ChatListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            listener = (ChatClickedListener) context;
        }
    }


    @Override
    protected int layoutRes() {
        return R.layout.fragment_chat;
    }

    @Override
    protected void initUi() {
        SharedPrefManager prefManager = new SharedPrefManager(getActivity());
        if (prefManager.isFirstRun()) {
            prefManager.writeFirstRun();
            ChatRoomModel chatmodel = new ChatRoomModel(0, "Abakar Magomedov", new MessageModel(0, 0, "Hi Abakar", 0, true), 24325435L);
            ChatRoomModel chatmodel2 = new ChatRoomModel(1, "Abakar Magomedov", new MessageModel(0, 0, "Hi Abakar", 0, true), 24325435L);
            ChatRoomModel chatmodel3 = new ChatRoomModel(2, "Abakar Magomedov", new MessageModel(0, 0, "Hi Abakar", 0, true), 24325435L);
            ChatRoomModel chatmodel4 = new ChatRoomModel(3, "Abakar Magomedov", new MessageModel(0, 0, "Hi Abakar", 0, true), 24325435L);
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(realm1 -> {
                realm1.insertOrUpdate(chatmodel);
                realm1.insertOrUpdate(chatmodel2);
                realm1.insertOrUpdate(chatmodel3);
                realm1.insertOrUpdate(chatmodel4);
            });
        }
        presenter.getAllChats();
    }

    @Override
    public void allChatsLoaded(List<ChatRoomEntity> chats) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ChatAdapter chatAdapter = new ChatAdapter(chats, ChatListFragment.this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(chatAdapter);
    }

    @Override
    public void showError(@NotNull String error) {
        errorDialogDelegate.showError(error);
    }

    @Override
    public void chatClicked(int chatId) {
        if (listener != null) {
            listener.chatRoomClicked(chatId);
        }
    }

}
