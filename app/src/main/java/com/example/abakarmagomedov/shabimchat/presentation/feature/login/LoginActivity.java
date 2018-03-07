package com.example.abakarmagomedov.shabimchat.presentation.feature.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.abakarmagomedov.shabimchat.SettingsActivity;
import com.example.abakarmagomedov.shabimchat.managers.NotificationManager;
import com.example.abakarmagomedov.shabimchat.R;
import com.example.abakarmagomedov.shabimchat.delegates.ErrorDialogDelegate;
import com.example.abakarmagomedov.shabimchat.presentation.base.BaseMvpActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.fresco.processors.BlurPostprocessor;
import jp.wasabeef.fresco.processors.CombinePostProcessors;
import jp.wasabeef.fresco.processors.GrayscalePostprocessor;

public class LoginActivity extends BaseMvpActivity<LoginView, LoginPresenter> implements LoginView {

    @Inject ErrorDialogDelegate errorDialogDelegate;
    @BindView(R.id.login_button) Button loginButton;
    @BindView(R.id.logo_view) SimpleDraweeView logoView;
    @BindView(R.id.registration_textview) TextView registrationTextView;
    @BindView(R.id.forgot_pass_tv) TextView forgotPass;
    private String email;

    @OnClick(R.id.login_button)
    void onLoginClicked() {
        errorDialogDelegate.showError("Oh i'm fucking coming");
    }

    @OnClick(R.id.forgot_pass_tv)
    void onForgotPassClicked() {
        showEmailDialog();
    }

    @OnClick(R.id.registration_textview)
    void onRegistrationClicked() {
        //для тесту
        NotificationManager notificationManager = new NotificationManager(getApplication());
        notificationManager.showNotify(1, "Опа", "Здарова");
        //для тесту

        Intent intent = new Intent(LoginActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    @Override
    public int layoutRes() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        CombinePostProcessors processor = new CombinePostProcessors.Builder()
                .add(new BlurPostprocessor(this))
                .add(new GrayscalePostprocessor())
                .build();
        ImageRequest request =
                ImageRequestBuilder.newBuilderWithSource(Uri.parse("https://storage.googleapis.com/gweb-uniblog-publish-prod/images/Search_logo.max-2800x2800.png"))
                        .setPostprocessor(processor)
                        .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .build();
        logoView.setController(controller);
    }

    private void showEmailDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(R.string.enter_email);

        final EditText email_et = new EditText(this);

        dialog.setView(email_et);
        dialog.setPositiveButton(R.string.ok, (dialog1, which) -> {
            email = email_et.getText().toString();
            dialog1.cancel();
        });

        dialog.setNegativeButton(R.string.cancel, (dialog12, which) -> dialog12.cancel());
        dialog.show();
    }
}
