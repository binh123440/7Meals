package com.example.cdpm_7meals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private EditText txtPassword;
    private ImageView imgEye;

    private TextView tv_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtPassword = findViewById(R.id.edit_text_password);
        imgEye = findViewById(R.id.image_view_eye);
        tv_click = findViewById(R.id.click);

        getWindow().setNavigationBarColor(Color.parseColor("#FDB222"));
        //status là thanh ở trên
        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));
        imgEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Kiểm tra trạng thái hiện tại của text view
                boolean isVisible = txtPassword.getTransformationMethod() == null;

                // Thay đổi trạng thái
                if (isVisible) {
                    // Ẩn mật khẩu
                    txtPassword.setTransformationMethod(new PasswordTransformationMethod());
                    imgEye.setImageResource(R.drawable.eye);
                } else {
                    // Hiện mật khẩu
                    txtPassword.setTransformationMethod(null);
                    imgEye.setImageResource(R.drawable.eye);
                }
            }
        });
        tv_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,SignIn.class));
            }
        });
    }
}