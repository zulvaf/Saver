package com.example.reducto.saver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SplashPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);
    }

    public void onSplashPageClick(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        //Starts the 'questions' activity
        startActivity(intent);
        //Closes this activity
        finish();
    }
}
