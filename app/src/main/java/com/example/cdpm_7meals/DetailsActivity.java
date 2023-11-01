package com.example.cdpm_7meals;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class DetailsActivity extends AppCompatActivity {

    private ImageButton back_bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        back_bt = findViewById(R.id.BackButton);
        back_bt.setOnClickListener(v -> {
            super.onBackPressed();
            onBackPressed();
        });

        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));
    }
}