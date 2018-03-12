package com.example.abakarmagomedov.shabimchat;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abakarmagomedov.shabimchat.data.mapper.ChatRoomMapper;
import com.example.abakarmagomedov.shabimchat.data.mapper.MessageMapper;
import com.example.abakarmagomedov.shabimchat.data.model.ChatRoomModel;
import com.example.abakarmagomedov.shabimchat.domain.entity.ChatRoomEntity;
import com.example.abakarmagomedov.shabimchat.managers.SharedPrefManager;
import com.example.abakarmagomedov.shabimchat.presentation.feature.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class ChatFragment extends Fragment implements ChatAdapter.ChatClickListener {

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private List<ChatRoomEntity> chats;
    private ChatClickedListener listener;
    private ChatRoomMapper mapper;

    public interface ChatClickedListener {
        void chatRoomClicked(int chatId);
    }

    public ChatFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ChatFragment newInstance() {
        ChatFragment fragment = new ChatFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof MainActivity) {
            listener = (ChatClickedListener) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        recyclerView = view.findViewById(R.id.chats_recycler_view);
        chats = new ArrayList<>();
        SharedPrefManager prefManager = new SharedPrefManager(getActivity());
        ChatRoomEntity chatEntity = new ChatRoomEntity(0, "Abakar Magomedov", "Hi Abakar", 24325435L);
        ChatRoomEntity chatEntity2 = new ChatRoomEntity(1, "Abakar Magomedov", "Hi Abakar", 24325435L);
        ChatRoomEntity chatEntity3 = new ChatRoomEntity(2, "Abakar Magomedov", "Hi Abakar", 24325435L);
        ChatRoomEntity chatEntity4 = new ChatRoomEntity(3, "Abakar Magomedov", "Hi Abakar", 24325435L);
        if (prefManager.isFirstRun()) {
            prefManager.writeFirstRun();
            ChatRoomModel chatmodel = new ChatRoomModel(0, "Abakar Magomedov", "Hi Abakar", 24325435L);
            ChatRoomModel chatmodel2 = new ChatRoomModel(1, "Abakar Magomedov", "Hi Abakar", 24325435L);
            ChatRoomModel chatmodel3 = new ChatRoomModel(2, "Abakar Magomedov", "Hi Abakar", 24325435L);
            ChatRoomModel chatmodel4 = new ChatRoomModel(3, "Abakar Magomedov", "Hi Abakar", 24325435L);
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(realm1 -> {
                realm1.insertOrUpdate(chatmodel);
                realm1.insertOrUpdate(chatmodel2);
                realm1.insertOrUpdate(chatmodel3);
                realm1.insertOrUpdate(chatmodel4);
            });
        }
        chats.add(chatEntity);
        chats.add(chatEntity2);
        chats.add(chatEntity3);
        chats.add(chatEntity4);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mapper = new ChatRoomMapper();
        chatAdapter = new ChatAdapter(chats, ChatFragment.this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(chatAdapter);
        return view;
    }

    @Override
    public void chatClicked(int chatId) {
        if (listener != null) {
            listener.chatRoomClicked(chatId);
        }
    }

}
