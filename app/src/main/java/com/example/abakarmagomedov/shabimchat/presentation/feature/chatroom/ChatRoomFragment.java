package com.example.abakarmagomedov.shabimchat.presentation.feature.chatroom;


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

import com.example.abakarmagomedov.shabimchat.TimeUtils;
import com.example.abakarmagomedov.shabimchat.domain.entity.ChatEntityMarker;
import com.example.abakarmagomedov.shabimchat.presentation.base.BaseMvpFragment;
import com.example.abakarmagomedov.shabimchat.presentation.base.CanShowError;
import com.example.abakarmagomedov.shabimchat.presentation.feature.chatroom.adapter.MessageAdapter;
import com.example.abakarmagomedov.shabimchat.R;
import com.example.abakarmagomedov.shabimchat.domain.entity.AudioMessageEntity;
import com.example.abakarmagomedov.shabimchat.domain.entity.MessageEntity;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ChatRoomFragment extends BaseMvpFragment<ChatRoomView, ChatRoomPresenter> implements ChatRoomView, CanShowError {

    public static final String CHAT_ROOM_ID = "chat_room_id";
    @BindView(R.id.recyclerview_message_list) RecyclerView chatRecyclerView;
    @BindView(R.id.button_chatbox_send) Button sendMessageButton;
    @BindView(R.id.record) ImageView record;
    @BindView(R.id.edittext_chatbox) EditText messageEditText;
    private List<ChatEntityMarker> messages;
    private MessageAdapter messageAdapter;
    private MediaRecorder mRecorder = null;
    private boolean isRecording;

    @OnClick(R.id.button_chatbox_send)
    void onSendButtonClicked() {
        MessageEntity message = new MessageEntity();
        message.setMessage(messageEditText.getText().toString().trim());
        message.setCreatedAt(System.currentTimeMillis());
        message.setSender(true);
        message.setId(System.currentTimeMillis());
        presenter.sendMessage(message, getArguments().getInt(CHAT_ROOM_ID, -5));
        messageEditText.setText("");
    }

    public ChatRoomFragment() {

    }

    public static ChatRoomFragment newInstance(int chatRoomId) {
        ChatRoomFragment fragment = new ChatRoomFragment();
        Bundle args = new Bundle();
        args.putInt(CHAT_ROOM_ID, chatRoomId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void loadedMessages(@NotNull List<? extends MessageEntity> messages) {
        // this.messages.clear();
        this.messages.addAll(0, messages);
        messageAdapter.notifyDataSetChanged();
    }

    @Override
    public void messageSentSuccessfully(MessageEntity messageEntity) {
        messages.add(0, messageEntity);
        messageAdapter.notifyDataSetChanged();
    }

    @Override
    public void messageNotSent(@NotNull MessageEntity message) {

    }

    @Override
    public void showError(@NotNull String error) {
        errorDialogDelegate.showError(error);
    }

    @Override
    protected int layoutRes() {
        return R.layout.fragment_chat_room;
    }

    @Override
    protected void initUi() {
        messages = new ArrayList<>();
        messages.add(new MessageEntity("Hello my friend", System.currentTimeMillis(), System.currentTimeMillis()));
        messageAdapter = new MessageAdapter(messages);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setReverseLayout(true);
        chatRecyclerView.setLayoutManager(layoutManager);
        chatRecyclerView.setAdapter(messageAdapter);
        record.setOnClickListener(v -> {
            File file = new File(getContext().getFilesDir(), String.valueOf(messages.size()));
            if (!isRecording) {
                startRecording(file);
                isRecording = true;
            } else {
                try {
                    stopRecording(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                isRecording = false;
            }
        });
        presenter.getAllMessages(getArguments().getInt(CHAT_ROOM_ID, -5));
    }

    private void startRecording(File file) {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
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

    private void stopRecording(File file) throws IOException {
        AudioMessageEntity audioMessage = new AudioMessageEntity();
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
}
