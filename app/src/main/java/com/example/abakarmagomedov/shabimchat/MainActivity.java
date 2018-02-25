package com.example.abakarmagomedov.shabimchat;


import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.abakarmagomedov.shabimchat.Entity.Message;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ChatFragment.ChatClickedListener {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
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
                    }
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
