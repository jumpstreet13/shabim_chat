package com.example.abakarmagomedov.shabimchat.delegates;


import android.support.v4.app.FragmentManager;

import com.example.abakarmagomedov.shabimchat.widgets.ErrorDialog;

/**
 * Created by abakarmagomedov on 26/02/2018 at project ShabimChat.
 */

public class ErrorDialogDelegate {

    private final FragmentManager fragmentManager;

    public ErrorDialogDelegate(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void showError(String error) {
        ErrorDialog.newInstance(error).show(fragmentManager, "");
    }

}
