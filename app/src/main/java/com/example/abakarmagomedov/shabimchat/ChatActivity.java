package com.example.abakarmagomedov.shabimchat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abakarmagomedov.shabimchat.Entity.ChatEntity;

import java.util.Arrays;
import java.util.Collections;

public class ChatActivity extends AppCompatActivity implements ChatAdapter.ChatClickListener {

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ChatEntity chatEntity = new ChatEntity("Abakar Magomedov", "Hi Abakar", 24325435L);
        chatAdapter = new ChatAdapter(Collections.singletonList(chatEntity), this);
        recyclerView = findViewById(R.id.chats_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chatAdapter);
    }

    @Override
    public void chatClicked(int chatId) {
        Intent intent = new Intent(this, ChatRoomActivity.class);
        intent.putExtra(ChatRoomActivity.CHAT_ROOM_ID, chatId);
        startActivity(intent);
    }

}
