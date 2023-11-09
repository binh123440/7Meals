package com.example.cdpm_7meals.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.adapters.ProfileAdapter2;

public class ProfileActivity extends AppCompatActivity {

    ListView simpleList;
    String List[] = {"Phone number", "Gender", "Birthday", "Address", "New Password","Confirm new Password","Enter your Password"};

    private AppCompatButton bt_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        simpleList = (ListView)findViewById(R.id.hoso);
        ProfileAdapter2 adapter	= new ProfileAdapter2(this, List,null);
        simpleList.setAdapter(adapter);

        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));

        bt_back = findViewById(R.id.button_back);
        bt_back.setOnClickListener(view -> {
            super.onBackPressed();
            onBackPressed();
        });
    }
}