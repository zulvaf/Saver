package com.example.reducto.saver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by zulvafachrina on 8/11/16.
 */
public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        TextView textView = (TextView) findViewById(R.id.title);
        textView.setText(R.string.daftar_alat);
        ImageButton imagebutton = (ImageButton) findViewById(R.id.deviceButton);
        imagebutton.setImageResource(R.drawable.ic_live_tv_white_36dp);
    }

}
