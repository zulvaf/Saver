package com.example.reducto.saver;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by zulvafachrina on 8/17/16.
 */
public class DialogInfoFragment extends DialogFragment {

    private String deviceName;
    private float deviceHours;
    private int devicePower;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        Bundle bundle = getArguments();
        deviceName = bundle.getString("DEVICE_NAME");
        deviceHours = bundle.getFloat("DEVICE_HOURS");
        devicePower = bundle.getInt("DEVICE_POWER");
        View myView = inflater.inflate(R.layout.dialog_info, null);

        TextView textView;
        textView = (TextView) myView.findViewById(R.id.itemName);
        textView.setText(deviceName);

        textView = (TextView) myView.findViewById(R.id.hoursLabel);
        textView.setText("Dinyalakan " + deviceHours + " jam");

        textView = (TextView) myView.findViewById(R.id.costLabel);
        int cost = (int) deviceHours * devicePower * 10;
        textView.setText("Biaya Rp " + cost);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(myView);



        return builder.create();
    }
}
