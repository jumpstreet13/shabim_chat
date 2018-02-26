package com.example.abakarmagomedov.shabimchat;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.abakarmagomedov.shabimchat.entity.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatRoomFragment extends Fragment {

    public static final String CHAT_ROOM_ID = "chat_room_id";
    private int chatId;
    private RecyclerView chatRecyclerView;
    private Button sendMessageButton;
    private List<Message> messages;
    private EditText messageEditText;
    private MessageAdapter messageAdapter;

    public ChatRoomFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ChatRoomFragment newInstance(int chatRoomId) {
        ChatRoomFragment fragment = new ChatRoomFragment();
        Bundle args = new Bundle();
        args.putInt(CHAT_ROOM_ID, chatRoomId);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chatId = getArguments().getInt(CHAT_ROOM_ID, -5);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_room, container, false);
        chatRecyclerView = view.findViewById(R.id.recyclerview_message_list);
        sendMessageButton = view.findViewById(R.id.button_chatbox_send);
        messageEditText = view.findViewById(R.id.edittext_chatbox);
        messages = new ArrayList<>();
        messages.add(new Message("Hello my friend", System.currentTimeMillis()));
        messageAdapter = new MessageAdapter(messages);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
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
        return view;
    }

}
