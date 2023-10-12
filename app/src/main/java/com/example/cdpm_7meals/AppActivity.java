package com.example.cdpm_7meals;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class AppActivity extends AppCompatActivity {
    private ImageButton back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietsp);

        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));

        back_button = findViewById(R.id.BackButton);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AppActivity.this,ListProduct.class);
                startActivity(intent);
            }
        });
    }
}
