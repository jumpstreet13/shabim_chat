package com.example.abakarmagomedov.shabimchat.widgets;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.example.abakarmagomedov.shabimchat.R;


/**
 * Created by abakarmagomedov on 26/02/2018 at project ShabimChat.
 */

public class ErrorDialog extends DialogFragment {

    private final static String EXTRA_MESSAGE = "extra_message";

    public static ErrorDialog newInstance(String message) {
        Bundle args = new Bundle();
        args.putString(EXTRA_MESSAGE, message);
        ErrorDialog fragment = new ErrorDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.ShabimDialogTheme);
        builder.setTitle(R.string.error)
                .setMessage(getArguments().getString(EXTRA_MESSAGE))
                .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });
        return builder.create();
    }

}
