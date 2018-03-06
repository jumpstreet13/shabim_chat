package com.example.abakarmagomedov.shabimchat;


import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.abakarmagomedov.shabimchat.domain.entity.AudioMessage;
import com.example.abakarmagomedov.shabimchat.domain.entity.Message;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatRoomFragment extends Fragment implements MessageAdapter.PlayMusicClickedListener {

    public static final String CHAT_ROOM_ID = "chat_room_id";
    private int chatId;
    private RecyclerView chatRecyclerView;
    private Button sendMessageButton;
    private List<ChatEntityMarker> messages;
    private EditText messageEditText;
    private MessageAdapter messageAdapter;
    private ImageView record;
    private MediaRecorder mRecorder = null;
    private MediaPlayer mPlayer = null;
    private boolean isRecording;

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat_room, container, false);
        chatRecyclerView = view.findViewById(R.id.recyclerview_message_list);
        sendMessageButton = view.findViewById(R.id.button_chatbox_send);
        record = view.findViewById(R.id.record);
        messageEditText = view.findViewById(R.id.edittext_chatbox);
        messages = new ArrayList<>();
        messages.add(new Message("Hello my friend", System.currentTimeMillis()));
        messageAdapter = new MessageAdapter(messages, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setReverseLayout(true);
        chatRecyclerView.setLayoutManager(layoutManager);
        chatRecyclerView.setAdapter(messageAdapter);
        sendMessageButton.setOnClickListener(v -> {
            Message message = new Message();
            message.setMessage(messageEditText.getText().toString().trim());
            message.setCreatedAt(System.currentTimeMillis());
            message.setSender(true);
            messages.add(0, message);
            messageAdapter.notifyDataSetChanged();
            messageEditText.setText("");
        });

        record.setOnClickListener(v -> {
            if (!isRecording) {
                startRecording();
                isRecording = true;
            } else {
                stopRecording();
                isRecording = false;
            }
        });
        return view;
    }

    private File file;

    private void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        file = new File(getContext().getFilesDir(), "userRecord");
        mRecorder.setOutputFile(file.getPath());
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
            mRecorder.start();
            Log.d("RECORD", "STARTED");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopRecording() {
        AudioMessage audioMessage = new AudioMessage();
        audioMessage.setCreatedAt(System.currentTimeMillis());
        audioMessage.setSender(true);
        audioMessage.setPathToFile(file.getPath());
        messages.add(0, audioMessage);
        messageAdapter.notifyDataSetChanged();
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
        Log.d("RECORD", "STOPPED");
    }

    @Override
    public void onMusicPlay(String pathToAudio) {
        startPlaying();
    }

    private void startPlaying() {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(file.getPath());
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Log.e("FAIL", "prepare() failed");
        }
    }

    private void stopPlaying() {
        mPlayer.release();
        mPlayer = null;
    }
}
