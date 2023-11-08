package com.example.bt4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.TooManyListenersException;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.example.bt4")){
            String receiveData = intent .getStringExtra("data_input");
            Toast.makeText(context, receiveData, Toast.LENGTH_SHORT).show();
        }
    }
}
