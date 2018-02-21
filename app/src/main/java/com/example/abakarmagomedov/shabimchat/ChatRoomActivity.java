package com.example.abakarmagomedov.shabimchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.abakarmagomedov.shabimchat.Entity.ChatEntity;
import com.example.abakarmagomedov.shabimchat.Entity.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatRoomActivity extends AppCompatActivity implements ChatAdapter.ChatClickListener {

    public static final String CHAT_ROOM_ID = "chat_room_id";
    private int chatId;
    private RecyclerView chatRecyclerView;
    private Button sendMessageButton;
    private List<Message> messages;
    private EditText messageEditText;
    private MessageAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);
        chatId = getIntent().getIntExtra(CHAT_ROOM_ID, -5);
        chatRecyclerView = findViewById(R.id.recyclerview_message_list);
        sendMessageButton = findViewById(R.id.button_chatbox_send);
        messageEditText = findViewById(R.id.edittext_chatbox);
        messages = new ArrayList<>();
        messages.add(new Message("Hello my friend", System.currentTimeMillis()));
        messageAdapter = new MessageAdapter(messages);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        chatRecyclerView.setLayoutManager(layoutManager);
        chatRecyclerView.setAdapter(messageAdapter);
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = new Message();
                message.setMessage(messageEditText.getText().toString().trim());
                message.setCreatedAt(System.currentTimeMillis());
                message.setSender(true);
                messages.add(0, message);
                messageAdapter.notifyDataSetChanged();
                messageEditText.setText("");
            }
        });
    }

    @Override
    public void chatClicked(int chatId) {

    }
}
