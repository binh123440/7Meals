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
import android.widget.Toast;

import com.example.cdpm_7meals.R;

import java.text.DecimalFormat;

public class DetailsActivity extends AppCompatActivity {

    private ImageButton back_bt;
    private AppCompatButton cart;
    private AppCompatButton cong;
    private AppCompatButton tru;
    private ImageView img;
    private TextView ten,mota,gia;
    private TextView sl;
    Integer price;
    Integer sl1, gia1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        img = findViewById(R.id.img_details_product);
        ten = findViewById(R.id.name_product);
        mota = findViewById(R.id.description_product);
        gia = findViewById(R.id.value_price_product);
        cart = findViewById(R.id.AddToCardButton);
        cong = findViewById(R.id.IncreseButton);
        tru = findViewById(R.id.DecreseButton);
        sl = findViewById(R.id.soluong);



        Intent intent = getIntent();
        if (intent != null) {
            int imgResource = intent.getIntExtra("imgResource", 0);
            String name = intent.getStringExtra("name");
            String des = intent.getStringExtra("dacta");
             price = 80000;
            img.setBackgroundResource(imgResource);
            ten.setText(name);
            mota.setText(des);
            gia.setText((price/1000) + "." + "000" + "VND");
        }

        back_bt = findViewById(R.id.BackButton);
        back_bt.setOnClickListener(v -> {
            super.onBackPressed();
            onBackPressed();
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slg = Integer.parseInt(sl.getText().toString());
                if (slg < 1) {
                    Toast.makeText(DetailsActivity.this, "Số lượng mặt hàng không đủ", Toast.LENGTH_SHORT).show();
                }

            }
        });
        ActionCongTru();
        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));
    }

    private void ActionCongTru() {

        cong.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                sl1 = getValue(sl);
                Integer kqua1 = sl1 + 1;
                sl.setText(kqua1.toString());
                Integer kqua2=kqua1*(price/1000);
                gia.setText( kqua2.toString()+ "." + "000" + "VND");
            }
        });

        tru.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sl1 = getValue(sl);
                Integer kqua1 = sl1 - 1;
                Integer kqua2=kqua1*(price/1000);
                if(sl1 > 0) {
                    sl.setText(kqua1.toString());
                    gia.setText(kqua2.toString()+ "." + "000" + "VND");
                }
                else {
                    sl.setText(sl1);
                    gia.setText(price);
                }
            }
        });
    }
    private Integer getValue(TextView text) {
            return Integer.parseInt(text.getText().toString());
    }

}