package com.example.reducto.saver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zulvafachrina on 8/18/16.
 */
public class StatusPageActivity extends AppCompatActivity {

    Device [] devices = {
            new Device("Kulkas", 500, 12),
            new Device("Televisi", 100, 5),
            new Device("Setrika", 0, 0)
    };

    public int maxPower = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_page);

        TextView textView = (TextView) findViewById(R.id.title);
        textView.setText(R.string.status);

        ImageButton imagebutton = (ImageButton) findViewById(R.id.powerButton);
        imagebutton.setImageResource(R.drawable.ic_battery_charging_full_white_36dp);

        ImageButton deviceButton = (ImageButton) findViewById(R.id.deviceButton);
        deviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StatusPageActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        textView = (TextView) findViewById(R.id.date);
        textView.setText("18 Agustus 2016");

        int totalPower = 0;
        int cost = 0;
        for (Device device:devices) {
            cost += device.power * device.hours * 10;
            totalPower += device.power;
        }

        textView = (TextView) findViewById(R.id.totalPower);
        textView.setText(totalPower + " / " + maxPower + " Watt");
        textView = (TextView) findViewById(R.id.totalCost);
        textView.setText("Rp " + cost);

        ImageView powerImage = (ImageView) findViewById(R.id.powerMeterImage);
        float percentage = (float)totalPower/(float)maxPower;
        if(percentage <= 0.3 ) {
            powerImage.setImageResource(R.drawable.wifi_low);
        } else if (percentage >= 0.3 && percentage < 0.75) {
            powerImage.setImageResource(R.drawable.wifi_medium);
        } else if(percentage >= 0.75 && percentage < 1) {
            powerImage.setImageResource(R.drawable.wifi_high);
        } else {
            powerImage.setImageResource(R.drawable.wifi_full);
        }

    }
}
