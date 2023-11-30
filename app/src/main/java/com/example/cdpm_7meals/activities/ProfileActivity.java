package com.example.cdpm_7meals.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.adapters.ProfileAdapter2;
import com.example.cdpm_7meals.data.UserSingleton;
import com.example.cdpm_7meals.fragments.ProfileFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity{

    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
    ListView simpleList;
    String List[] = {"Name","Phone number", "Gender", "Birthday", "Address", "Password"};
    String ListValue[];
    ProfileAdapter2 adapter;
    ImageView img_profile;

    private AppCompatButton bt_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        img_profile = findViewById(R.id.image_profile);

        ListValue = new String[6];

        myRef.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserSingleton userSingleton = UserSingleton.getInstance();
                String phoneNum = userSingleton.getUsername();
                if(snapshot.hasChild(phoneNum)){
                    String name = snapshot.child(phoneNum).child("lastname").getValue(String.class);
                    String gender = snapshot.child(phoneNum).child("gender").getValue(String.class);
                    String birthday = snapshot.child(phoneNum).child("birthday").getValue(String.class);
                    String address = snapshot.child(phoneNum).child("adress").getValue(String.class);
                    String password = snapshot.child(phoneNum).child("password").getValue(String.class);
                    String img = snapshot.child(phoneNum).child("image").getValue(String.class);

                    //Picasso.get().load(img).into(img_profile);

                    ListValue[0] = name;
                    ListValue[1] = phoneNum;
                    ListValue[2] = gender;
                    ListValue[3] = birthday;
                    ListValue[4] = address;
                    ListValue[5] = password;

                    simpleList = findViewById(R.id.hoso);
                    adapter	= new ProfileAdapter2(ProfileActivity.this, List, ListValue,null);
                    simpleList.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));

        bt_back = findViewById(R.id.button_back);
        bt_back.setOnClickListener(view -> {
            super.onBackPressed();
            onBackPressed();
        });
    }
}