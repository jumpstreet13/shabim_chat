package com.example.abakarmagomedov.shabimchat;

import android.app.PendingIntent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abakarmagomedov.shabimchat.entity.AudioMessage;
import com.example.abakarmagomedov.shabimchat.entity.Message;

import java.util.List;

/**
 * Created by abakarmagomedov on 21/02/2018 at project ShabimChat.
 */

public class MessageAdapter extends RecyclerView.Adapter {

    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;
    private static final int VIEW_TYPE_AUDIO_MESSAGE_SENT = 3;
    private PlayMusicClickedListener listener;

    public interface PlayMusicClickedListener {
        void onMusicPlay(String pathToAudio);
    }

    private List<ChatEntityMarker> messages;

    public MessageAdapter(List<ChatEntityMarker> messages, PlayMusicClickedListener listener) {
        this.messages = messages;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case VIEW_TYPE_MESSAGE_RECEIVED:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.received_message_item, parent, false);
                return new ReceiveMessageHolder(view);
            case VIEW_TYPE_MESSAGE_SENT:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.sent_message_item, parent, false);
                return new SentMessageHolder(view);
            case VIEW_TYPE_AUDIO_MESSAGE_SENT:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.sent_audio_message_item, parent, false);
                return new SentAudioMessageHolder(view);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChatEntityMarker message = messages.get(position);

        switch (holder.getItemViewType()) {
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((ReceiveMessageHolder) holder).bind((Message) message);
                break;
            case VIEW_TYPE_MESSAGE_SENT:
                ((SentMessageHolder) holder).bind((Message) message);
                break;
            case VIEW_TYPE_AUDIO_MESSAGE_SENT:
                ((SentAudioMessageHolder) holder).bind((AudioMessage) message, listener);
        }
    }

    @Override
    public int getItemViewType(int position) {
        ChatEntityMarker message = messages.get(position);
        if (message instanceof Message) {
            if (message.isFromSender()) return VIEW_TYPE_MESSAGE_SENT;
            else return VIEW_TYPE_MESSAGE_RECEIVED;
        }
        if (message instanceof AudioMessage) {
            if (message.isFromSender()) return VIEW_TYPE_AUDIO_MESSAGE_SENT;
            else return -5;
        }
        throw new IllegalStateException("Undefined viewtype");
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }


    private static class ReceiveMessageHolder extends RecyclerView.ViewHolder {

        private TextView receivedMessage, receivedMessageTime;

        public ReceiveMessageHolder(View itemView) {
            super(itemView);
            receivedMessage = itemView.findViewById(R.id.received_message_text);
            receivedMessageTime = itemView.findViewById(R.id.received_message_time);
        }

        void bind(Message message) {
            receivedMessage.setText(message.getMessage());
            receivedMessageTime.setText(TimeUtils.formatDateFromLong(message.getCreatedAt()));
        }
    }

    private static class SentMessageHolder extends RecyclerView.ViewHolder {

        private TextView sentMessage, sentMessageTime;

        public SentMessageHolder(View itemView) {
            super(itemView);
            sentMessage = itemView.findViewById(R.id.sent_message_text);
            sentMessageTime = itemView.findViewById(R.id.sent_message_time);
        }

        void bind(Message message) {
            sentMessage.setText(message.getMessage());
            sentMessageTime.setText(TimeUtils.formatDateFromLong(message.getCreatedAt()));
        }
    }

    private static class SentAudioMessageHolder extends RecyclerView.ViewHolder {

        private ImageView playMusic;
        private boolean isPlayed;

        public SentAudioMessageHolder(View itemView) {
            super(itemView);
            playMusic = itemView.findViewById(R.id.playMusic);
        }

        void bind(AudioMessage message, PlayMusicClickedListener clickedListener) {
            playMusic.setOnClickListener(v -> {
                if (!isPlayed) {
                    clickedListener.onMusicPlay(message.getPathToFile());
                    playMusic.setImageResource(R.drawable.ic_pause);
                    isPlayed = true;
                } else {
                    playMusic.setImageResource(R.drawable.ic_play_arrow);
                    isPlayed = false;
                }
            });
        }
    }
}









