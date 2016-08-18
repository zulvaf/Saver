package com.example.reducto.saver;

import android.app.Activity;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zulvafachrina on 8/16/16.
 */

class Device {
    public String name;
    public int power;
    public float hours;

    public Device(String name, int power, float hours) {
        this.name = name;
        this.power = power;
        this.hours = hours;
    }
}

public class CustomListAdapter extends ArrayAdapter<Device> {
    private final Activity context;
    private final Device[] items;

    public CustomListAdapter(Activity context, Device[] devices) {
        super(context, R.layout.single_list, devices);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.items=devices;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.single_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.itemName);
        TextView extratxt = (TextView) rowView.findViewById(R.id.itemPower);

        txtTitle.setText(items[position].name);
        extratxt.setText(items[position].power + " watt/10 k");

        return rowView;

    };
}
