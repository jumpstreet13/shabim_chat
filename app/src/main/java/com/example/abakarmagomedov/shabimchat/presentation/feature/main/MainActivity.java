package com.example.abakarmagomedov.shabimchat.presentation.feature.main;


import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.abakarmagomedov.shabimchat.presentation.feature.chatlist.ChatFragment;
import com.example.abakarmagomedov.shabimchat.R;
import com.example.abakarmagomedov.shabimchat.presentation.base.ToolbarActivity;
import com.example.abakarmagomedov.shabimchat.presentation.feature.chatroom.ChatRoomFragment;

import butterknife.BindView;

public class MainActivity extends ToolbarActivity<MainView, MainPresenter> implements ChatFragment.ChatClickedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private DrawerLayout mDrawerLayout;

    @Override
    public int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setToolbar(toolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                menuItem -> {
                    menuItem.setChecked(true);
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    mDrawerLayout.closeDrawers();
                    switch (menuItem.getGroupId()) {
                        case 0:
                            Fragment chatFragment = ChatFragment.newInstance();
                            transaction.replace(R.id.content_frame, chatFragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                            break;
                        case 1:

                            break;

                        case 2:
                            break;
                    }
                    // Add code here to update the UI based on the item selected
                    // For example, swap UI fragments here
                    return true;
                });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void chatRoomClicked(int chatId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment chatRoomFragment = ChatRoomFragment.newInstance(chatId);
        transaction.replace(R.id.content_frame, chatRoomFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
