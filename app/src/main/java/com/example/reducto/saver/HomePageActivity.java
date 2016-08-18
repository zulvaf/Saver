package com.example.reducto.saver;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by zulvafachrina on 8/11/16.
 */
public class HomePageActivity extends AppCompatActivity {

    Device [] devicesOn = {
            new Device("Kulkas", 500, 12),
            new Device("Televisi", 100, 5)
    };

    Device [] devicesOff = {
            new Device("Setrika", 0, 0)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        TextView textView = (TextView) findViewById(R.id.title);
        textView.setText(R.string.daftar_alat);

        ImageButton imagebutton = (ImageButton) findViewById(R.id.deviceButton);
        imagebutton.setImageResource(R.drawable.ic_live_tv_white_36dp);

        ImageButton powerButton = (ImageButton) findViewById(R.id.powerButton);
        powerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, StatusPageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, AddDeviceActivity.class);
                startActivity(intent);
            }
        });

        CustomListAdapter adapterOn=new CustomListAdapter(this, devicesOn);
        ListView listOn=(ListView)findViewById(R.id.deviceOnList);
        listOn.setAdapter(adapterOn);
        listOn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                Device item = (Device) adapter.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putString("DEVICE_NAME", item.name);
                bundle.putFloat("DEVICE_HOURS", item.hours);
                bundle.putInt("DEVICE_POWER", item.power);


                DialogFragment newFragment = new DialogInfoFragment();
                newFragment.setArguments(bundle);
                newFragment.show(getFragmentManager(), "info");

            }
        });

        CustomListAdapter adapterOff=new CustomListAdapter(this, devicesOff);
        ListView listOff=(ListView)findViewById(R.id.deviceOffList);
        listOff.setAdapter(adapterOff);

        listOff.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                Device item = (Device) adapter.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putString("DEVICE_NAME", item.name);
                bundle.putFloat("DEVICE_HOURS", item.hours);
                bundle.putInt("DEVICE_POWER", item.power);


                DialogFragment newFragment = new DialogInfoFragment();
                newFragment.setArguments(bundle);
                newFragment.show(getFragmentManager(), "info");

            }
        });


    }


}
