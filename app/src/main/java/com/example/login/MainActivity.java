package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private EditText txtPassword;
    private ImageView imgEye;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtPassword = findViewById(R.id.edit_text_password);
        imgEye = findViewById(R.id.image_view_eye);
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
    }
}