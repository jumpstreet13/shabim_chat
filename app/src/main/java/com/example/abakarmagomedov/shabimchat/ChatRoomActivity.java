package com.example.abakarmagomedov.shabimchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ChatRoomActivity extends AppCompatActivity {

    public static final String CHAT_ROOM_ID = "chat_room_id";
    private int chatId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);
        chatId = getIntent().getIntExtra(CHAT_ROOM_ID, -5);
    }

}
