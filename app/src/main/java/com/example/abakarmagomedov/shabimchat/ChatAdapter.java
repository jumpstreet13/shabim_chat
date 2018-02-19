package com.example.abakarmagomedov.shabimchat;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.abakarmagomedov.shabimchat.Entity.ChatEntity;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.List;

/**
 * Created by abakarmagomedov on 16/02/2018 at project ShabimChat.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatHolder> {

    private List<ChatEntity> chats;

    public ChatAdapter(List<ChatEntity> chats) {
        this.chats = chats;
    }

    @Override
    public ChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.chat_item, parent, false);
        return new ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatHolder holder, int position) {
        ChatEntity chatEntity = chats.get(position);
        holder.bindView(chatEntity);
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    static class ChatHolder extends RecyclerView.ViewHolder {

        private TextView recipientName, messageText, messageTime;
        private SimpleDraweeView recipientAvatar, senderAvatar;

        public ChatHolder(View itemView) {
            super(itemView);
            recipientName = itemView.findViewById(R.id.recipient_name);
            recipientAvatar = itemView.findViewById(R.id.recipient_avatar);
            messageText = itemView.findViewById(R.id.message_text);
            messageTime = itemView.findViewById(R.id.message_time);
            senderAvatar = itemView.findViewById(R.id.sender_avatar);
        }

        void bindView(ChatEntity chatEntity) {
            recipientName.setText(chatEntity.getRecepientName());
            messageText.setText(chatEntity.getMessageText());
            messageTime.setText("21.16");

            ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse("https://blog.caranddriver.com/wp-content/uploads/2017/04/cars_3_characters-1-876x535.jpg")).build();
            senderAvatar.setImageURI(imageRequest.getSourceUri());

            ImageRequest imageRequestRecipient = ImageRequestBuilder.newBuilderWithSource(Uri.parse("https://blog.caranddriver.com/wp-content/uploads/2017/04/cars_3_characters-2-876x535.jpg")).build();
            recipientAvatar.setImageURI(imageRequestRecipient.getSourceUri());

        }
    }

}













