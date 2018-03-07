package com.example.abakarmagomedov.shabimchat.delegates;


import android.support.v4.app.FragmentManager;

import com.example.abakarmagomedov.shabimchat.widgets.ErrorDialog;

import javax.inject.Inject;

/**
 * Created by abakarmagomedov on 26/02/2018 at project ShabimChat.
 */

public class ErrorDialogDelegate {

    private final FragmentManager fragmentManager;

    @Inject
    public ErrorDialogDelegate(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void showError(String error) {
        ErrorDialog.newInstance(error).show(fragmentManager, "");
    }

}
