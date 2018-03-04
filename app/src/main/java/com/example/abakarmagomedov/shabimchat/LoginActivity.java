package com.example.abakarmagomedov.shabimchat;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.abakarmagomedov.shabimchat.Utilities.NotificationManager;
import com.example.abakarmagomedov.shabimchat.delegates.ErrorDialogDelegate;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import jp.wasabeef.fresco.processors.BlurPostprocessor;
import jp.wasabeef.fresco.processors.CombinePostProcessors;
import jp.wasabeef.fresco.processors.GrayscalePostprocessor;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private SimpleDraweeView logoView;
    private CombinePostProcessors processor;
    private TextView registrationTextView;
    private TextView forgotPass;
    private String email;
    private ErrorDialogDelegate errorDialogDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        forgotPass = findViewById(R.id.forgot_pass_tv);
        forgotPass.setOnClickListener(v -> showEmailDialog());
        loginButton = findViewById(R.id.login_button);
        errorDialogDelegate = new ErrorDialogDelegate(getSupportFragmentManager());
        registrationTextView = findViewById(R.id.registration_textview);
        loginButton.setOnClickListener(v -> {
            errorDialogDelegate.showError("Oh i'm fucking coming");
            //Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            //startActivity(intent);
        });
        registrationTextView.setOnClickListener(v -> {
//            Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
//            startActivity(intent);
            NotificationManager notificationManager = new NotificationManager(getApplication());
            notificationManager.setSoundNotify(true);
            notificationManager.setVibrateNotify(true);
            notificationManager.showNotify(1,"Опа", "Здарова");

        });
        logoView = findViewById(R.id.logo_view);
        processor = new CombinePostProcessors.Builder()
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
