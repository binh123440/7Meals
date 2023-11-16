package com.example.cdpm_7meals.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.adapters.ProfileAdapter2;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    ListView simpleList;
    String List[] = {"Name","Phone number", "Gender", "Birthday", "Address", "Password"};
    String ListValue[];

    private AppCompatButton bt_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String phoneNumber = intent.getStringExtra("phonenumber");
            String gender = intent.getStringExtra("gender");
            String birthday = intent.getStringExtra("birthday");
            String address = intent.getStringExtra("address");
            String username = intent.getStringExtra("username");
            String password = intent.getStringExtra("password");

            if (ListValue == null) {
                ListValue = new String[7];
            }

            ListValue[0] = name;
            ListValue[1] = phoneNumber;
            ListValue[2] = gender;
            ListValue[3] = birthday;
            ListValue[4] = address;
            ListValue[5] = username;
            ListValue[6] = password;
        }

        simpleList = (ListView)findViewById(R.id.hoso);
        ProfileAdapter2 adapter	= new ProfileAdapter2(this, List, ListValue,null);
        simpleList.setAdapter(adapter);

        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));

        bt_back = findViewById(R.id.button_back);
        bt_back.setOnClickListener(view -> {
            super.onBackPressed();
            onBackPressed();
        });
    }
}