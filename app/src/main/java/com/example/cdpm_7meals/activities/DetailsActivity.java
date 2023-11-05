package com.example.cdpm_7meals.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cdpm_7meals.R;

public class DetailsActivity extends AppCompatActivity {

    private ImageButton back_bt;

    private ImageView img;
    private TextView ten,mota,gia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        img = findViewById(R.id.img_details_product);
        ten = findViewById(R.id.name_product);
        mota = findViewById(R.id.description_product);
        gia = findViewById(R.id.value_price_product);

        Intent intent = getIntent();
        if (intent != null)
        {
            int imgResource = intent.getIntExtra("imgResource",0);
            String name = intent.getStringExtra("name");
            String des = intent.getStringExtra("dacta");
            Long price = intent.getLongExtra("gia",0);
            img.setBackgroundResource(imgResource);
            ten.setText(name);
            mota.setText(des);
            gia.setText(price/1000 + "." + "000" + " VND");
        }

        back_bt = findViewById(R.id.BackButton);
        back_bt.setOnClickListener(v -> {
            super.onBackPressed();
            onBackPressed();
        });

        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));
    }
}