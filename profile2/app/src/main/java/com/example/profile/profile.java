package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.profile.Adapter.ProfileAdapter2;

public class profile extends AppCompatActivity {
    ListView simpleList;
    String List[] = {"Phone number", "Gender", "Birthday", "Address", "New Password","Confirm new Password","Enter your Password"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        simpleList	=	 (ListView)findViewById(R.id.hoso);
        ProfileAdapter2 adapter	= 	new ProfileAdapter2(this, List,null);
        simpleList.setAdapter(adapter);
        Button back = (Button) findViewById(R.id.backve);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(profile.this, profilemain.class);
                startActivity(myintent);
            }
        });
    }
}