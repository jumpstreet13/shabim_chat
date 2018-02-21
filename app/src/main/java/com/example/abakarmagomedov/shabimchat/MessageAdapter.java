package com.example.abakarmagomedov.shabimchat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abakarmagomedov.shabimchat.Entity.Message;

import java.util.List;

/**
 * Created by abakarmagomedov on 21/02/2018 at project ShabimChat.
 */

public class MessageAdapter extends RecyclerView.Adapter {

    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

    private List<Message> messages;

    public MessageAdapter(List<Message> messages) {
        this.messages = messages;
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
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Message message = messages.get(position);

        switch (holder.getItemViewType()) {
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((ReceiveMessageHolder) holder).bind(message);
                break;
            case VIEW_TYPE_MESSAGE_SENT:
                ((SentMessageHolder) holder).bind(message);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messages.get(position);
        if (message.isSender()) return VIEW_TYPE_MESSAGE_SENT;
        else return VIEW_TYPE_MESSAGE_RECEIVED;
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
}









