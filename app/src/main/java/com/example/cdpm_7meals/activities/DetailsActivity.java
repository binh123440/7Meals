package com.example.cdpm_7meals.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.models.Food;
import com.example.cdpm_7meals.models.Product2;

public class DetailsActivity extends AppCompatActivity {

    private ImageButton back_bt;
    private AppCompatButton IncreseButton;
    private AppCompatButton DecreseButton;

    private ImageView img;
    private TextView name, desc, price, tvTotal;
    int count = 1;
    Long Price;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        img = findViewById(R.id.img_details_product);
        name = findViewById(R.id.name_product);
        desc = findViewById(R.id.description_product);
        price = findViewById(R.id.value_price_product);
        IncreseButton = findViewById(R.id.IncreseButton);
        DecreseButton = findViewById(R.id.DecreseButton);
        tvTotal = findViewById(R.id.tvTotal);

        Intent intent = getIntent();
        Product2 product = getIntent().getParcelableExtra("food");

        if (product != null) {
            Log.d("__test", "onCreate: " + product.getPrice());

            Glide.with(this).load(product.getImage()).into(img);
            name.setText(product.getName());
            desc.setText(product.getDesc());
            Price = product.getPrice();
            price.setText(Price / 1000 + "." + "000" + " VND");
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

                if (count > 1) {
                    count--;
                    price.setText((Price * count) / 1000 + ".000 VND");
                }
                tvTotal.setText(String.valueOf(count));
            }
        });
        IncreseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                price.setText((Price * count) / 1000 + ".000 VND");
                tvTotal.setText(String.valueOf(count));

            }
        });

        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));
    }
}