package com.example.abakarmagomedov.shabimchat;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abakarmagomedov.shabimchat.entity.ChatEntity;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment implements ChatAdapter.ChatClickListener {

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private List<ChatEntity> chats;
    private ChatClickedListener listener;

    public interface ChatClickedListener {
        void chatRoomClicked(int chatId);
    }

    public ChatFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ChatFragment newInstance() {
        ChatFragment fragment = new ChatFragment();
        //Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof MainActivity) {
            listener = (ChatClickedListener) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        recyclerView = view.findViewById(R.id.chats_recycler_view);
        chats = new ArrayList<>();
        ChatEntity chatEntity = new ChatEntity("Abakar Magomedov", "Hi Abakar", 24325435L);
        ChatEntity chatEntity2 = new ChatEntity("Abakar Magomedov", "Hi Abakar", 24325435L);
        ChatEntity chatEntity3 = new ChatEntity("Abakar Magomedov", "Hi Abakar", 24325435L);
        ChatEntity chatEntity4 = new ChatEntity("Abakar Magomedov", "Hi Abakar", 24325435L);
        chats.add(chatEntity);
        chats.add(chatEntity2);
        chats.add(chatEntity3);
        chats.add(chatEntity4);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        chatAdapter = new ChatAdapter(chats, this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(chatAdapter);
        return view;
    }

    @Override
    public void chatClicked(int chatId) {
        if (listener != null) {
            listener.chatRoomClicked(chatId);
        }
    }

}
