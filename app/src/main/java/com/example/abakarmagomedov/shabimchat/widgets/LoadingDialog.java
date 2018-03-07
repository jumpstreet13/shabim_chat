package com.example.abakarmagomedov.shabimchat.widgets;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import com.example.abakarmagomedov.shabimchat.R;
import com.example.abakarmagomedov.shabimchat.util.DisplayMetricsUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by abakarmagomedov on 07/03/2018 at project ShabimChat.
 */

public class LoadingDialog extends DialogFragment {

    private Unbinder unbinder;

    @BindView(R.id.loader)
    ProgressBar loader;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.loading_dialog, null);
        unbinder = ButterKnife.bind(this, view);
        loader.setVisibility(View.VISIBLE);
        builder.setView(view);
        return builder.create();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
        DisplayMetrics metrics = new DisplayMetrics();
        Window window = getDialog().getWindow();
        window.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int dialogHeightPx = DisplayMetricsUtil.dpToPx(getContext(), 148);
        window.setLayout(dialogHeightPx, dialogHeightPx);
        window.setGravity(Gravity.CENTER);
    }


}
