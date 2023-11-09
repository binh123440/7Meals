package com.example.cdpm_7meals.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.cdpm_7meals.R;

public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        Spinner spinner1= findViewById(R.id.spiner1);
        Spinner spinner2= findViewById(R.id.spiner2);
        Spinner spinner3= findViewById(R.id.spiner3);
        Spinner spinner4= findViewById(R.id.spiner4);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                RulesActivity.this,
                R.array.list,
                R.layout.dropdowncheck
        );
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(
                RulesActivity.this,
                R.array.list2,
                R.layout.dropdowncheck
        );
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(
                RulesActivity.this,
                R.array.list3,
                R.layout.dropdowncheck
        );
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(
                RulesActivity.this,
                R.array.list4,
                R.layout.dropdowncheck
        );
        adapter.setDropDownViewResource(R.layout.dropdownitem);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter1);
        spinner3.setAdapter(adapter2);
        spinner4.setAdapter(adapter3);
        AppCompatButton back = (AppCompatButton) findViewById(R.id.backve);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RulesActivity.super.onBackPressed();
                onBackPressed();
            }
        });

        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));
    }
}