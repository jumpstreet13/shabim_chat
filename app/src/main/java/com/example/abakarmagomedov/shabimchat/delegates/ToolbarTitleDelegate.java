package com.example.abakarmagomedov.shabimchat.delegates;

import android.app.Activity;

import com.example.abakarmagomedov.shabimchat.presentation.base.ToolbarTitleManager;

import javax.inject.Inject;

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */

public class ToolbarTitleDelegate {

    private final ToolbarTitleManager manager;
    
    public ToolbarTitleDelegate(Activity activity) {
        if (activity instanceof ToolbarTitleManager) {
            this.manager = (ToolbarTitleManager) activity;
        } else
            throw new ClassCastException("Your activity has to implement ToolbarTitleManager interface");
    }

    public void changeTitle(String title) {
        manager.changeTitle(title);
    }
}
