package com.example.abakarmagomedov.shabimchat.delegates;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

import com.example.abakarmagomedov.shabimchat.widgets.LoadingDialog;

import javax.inject.Inject;

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */

public class LoaderDialogDelegate {

    private final FragmentManager fragmentManager;

    private final DialogFragment dialog;

    public LoaderDialogDelegate(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        this.dialog = new LoadingDialog();
    }

    public void showLoading(boolean show) {
        if (show) {
            dialog.show(fragmentManager, "");
        } else {
            dialog.dismiss();
        }
    }

}
