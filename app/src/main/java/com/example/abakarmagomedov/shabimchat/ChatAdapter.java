package com.example.abakarmagomedov.shabimchat;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by abakarmagomedov on 16/02/2018 at project ShabimChat.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder> {

    public ChatAdapter() {

    }

    @Override
    public ChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.chat_item, parent, false);
        return new ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatHolder holder, int position) {
        holder.bindView();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ChatHolder extends RecyclerView.ViewHolder {

        public ChatHolder(View itemView) {
            super(itemView);
        }

        void bindView() {
        }
    }

}
