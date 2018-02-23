package com.example.abakarmagomedov.shabimchat;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by Никита on 23.02.2018.
 */

public class SettingsActivity extends AppCompatActivity {
    private Switch sound_sw, vibro_sw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        sound_sw = findViewById(R.id.sound_sw);
        vibro_sw = findViewById(R.id.vibro_sw);

        sound_sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sound_sw.isChecked()){
                    Toast.makeText(getApplicationContext(), "Звуковые уведомления включены", Toast.LENGTH_SHORT).show();
                    //Написать кокманду включения и отключения звука на устройстве
                }
                else {
                    Toast.makeText(getApplicationContext(), "Звуковые уведомления отключены", Toast.LENGTH_SHORT).show();
                }
            }
        });
        vibro_sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (vibro_sw.isChecked()){
                    Toast.makeText(getApplicationContext(), "Вибрация включена", Toast.LENGTH_SHORT).show();
                    //Написать кокманду включения и отключения вибрации на устройстве
                }
                else {
                    Toast.makeText(getApplicationContext(), "Вибрация отключена", Toast.LENGTH_SHORT).show();
                }
            }
        });



         }
}
