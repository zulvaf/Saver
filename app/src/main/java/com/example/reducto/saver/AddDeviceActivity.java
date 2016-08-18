package com.example.reducto.saver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by zulvafachrina on 8/17/16.
 */
public class AddDeviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_device_page);
        TextView textView = (TextView) findViewById(R.id.title);
        textView.setText(R.string.tambah_alat);

        ImageButton imagebutton = (ImageButton) findViewById(R.id.deviceButton);
        imagebutton.setImageResource(R.drawable.ic_live_tv_white_36dp);

        ImageButton powerButton = (ImageButton) findViewById(R.id.powerButton);
        powerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddDeviceActivity.this, StatusPageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ImageButton deviceButton = (ImageButton) findViewById(R.id.deviceButton);
        deviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddDeviceActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
