package com.example.abakarmagomedov.shabimchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abakarmagomedov.shabimchat.Entity.ChatEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChatActivity extends AppCompatActivity implements ChatAdapter.ChatClickListener {

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private List<ChatEntity> chats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        recyclerView = findViewById(R.id.chats_recycler_view);
        chats = new ArrayList<>();
        ChatEntity chatEntity = new ChatEntity("Abakar Magomedov", "Hi Abakar", 24325435L);
        ChatEntity chatEntity2 = new ChatEntity("Abakar Magomedov", "Hi Abakar", 24325435L);
        ChatEntity chatEntity3 = new ChatEntity("Abakar Magomedov", "Hi Abakar", 24325435L);
        ChatEntity chatEntity4 = new ChatEntity("Abakar Magomedov", "Hi Abakar", 24325435L);
        chats.add(chatEntity);
        chats.add(chatEntity2);
        chats.add(chatEntity3);
        chats.add(chatEntity4);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        chatAdapter = new ChatAdapter(chats, this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(chatAdapter);
    }

    @Override
    public void chatClicked(int chatId) {
        Intent intent = new Intent(this, ChatRoomActivity.class);
        intent.putExtra(ChatRoomActivity.CHAT_ROOM_ID, chatId);
        startActivity(intent);
    }

}
