package com.example.bt4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView textView;
    private AppCompatButton bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String data_input = getIntent().getStringExtra("input");
        textView = findViewById(R.id.tv);
        textView.setText(data_input);

        bt = findViewById(R.id.bt_gui);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent broadcastReceiver = new Intent("com.example.bt4");
                broadcastReceiver.putExtra("data_input",data_input);
                sendBroadcast(broadcastReceiver);
            }
        });
    }
}