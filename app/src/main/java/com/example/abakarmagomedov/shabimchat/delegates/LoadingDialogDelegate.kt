package com.example.abakarmagomedov.shabimchat.delegates

import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import com.example.abakarmagomedov.shabimchat.widgets.LoadingDialog

/**
 * Created by abakarmagomedov on 19/06/2018 at project ShabimChat.
 */
class LoadingDialogDelegate(private var fragmentManager: FragmentManager) {

    private var dialog: DialogFragment = LoadingDialog()

    fun showLoading(show: Boolean) {
        if (show) {
            dialog.show(fragmentManager, "")
        } else {
            dialog.dismiss()
        }
    }

}