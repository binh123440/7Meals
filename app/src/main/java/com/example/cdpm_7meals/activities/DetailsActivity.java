package com.example.cdpm_7meals.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cdpm_7meals.R;

public class DetailsActivity extends AppCompatActivity {

    private ImageButton back_bt;
    private AppCompatButton IncreseButton;
    private AppCompatButton DecreseButton;

    private ImageView img;
    private TextView ten, mota, gia, tvTotal;
    int count = 1;
    Long price ;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        img = findViewById(R.id.img_details_product);
        ten = findViewById(R.id.name_product);
        mota = findViewById(R.id.description_product);
        gia = findViewById(R.id.value_price_product);
        IncreseButton = findViewById(R.id.IncreseButton);
        DecreseButton = findViewById(R.id.DecreseButton);
        tvTotal = findViewById(R.id.tvTotal);

        Intent intent = getIntent();
        if (intent != null) {
            String imgResource = intent.getStringExtra("imgResource");
            String name = intent.getStringExtra("name");
            String des = intent.getStringExtra("dacta");
             price = intent.getLongExtra("gia", 0);
            Glide.with(this)
                    .load(imgResource)
                    .into(img);
            ten.setText(name);
            mota.setText(des);
            gia.setText(price / 1000 + "." + "000" + " VND");
        }

        back_bt = findViewById(R.id.BackButton);
        back_bt.setOnClickListener(v -> {
            super.onBackPressed();
            onBackPressed();
        });



        DecreseButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                if (count >0){
                    count--;
                    gia.setText((price*count)/ 1000 +".000 VND");
                }else {
                    gia.setText((price*count)+" VND");
                }

                tvTotal.setText(String.valueOf(count));


            }
        });
        IncreseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                gia.setText((price*count)/ 1000 +".000 VND");
                tvTotal.setText(String.valueOf(count));

            }
        });

        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));
    }
}