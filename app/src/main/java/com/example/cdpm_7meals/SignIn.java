package com.example.cdpm_7meals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    private TextView btn_back;

    private AppCompatButton btn_signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getWindow().setNavigationBarColor(Color.parseColor("#FDB222"));
        //status là thanh ở trên
        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));

        btn_back = findViewById(R.id.nutback);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this,Login.class));
            }
        });

        btn_signin = findViewById(R.id.nutSignin);
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, AppActivity.class));
            }
        });
    }
}