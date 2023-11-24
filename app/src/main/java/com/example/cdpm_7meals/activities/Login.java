package com.example.cdpm_7meals.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.data.UserSingleton;
import com.example.cdpm_7meals.fragments.HomeFragment;
import com.example.cdpm_7meals.fragments.ProfileFragment;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private EditText txtPassword;
    private ImageView imgEye;
    EditText phonenum, password;
    private AppCompatButton bt_login;

    private TextView tv_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        txtPassword = findViewById(R.id.edit_text_password);
        imgEye = findViewById(R.id.image_view_eye);
        tv_click = findViewById(R.id.click);
        phonenum = findViewById(R.id.edit_text_username);
        password = findViewById((R.id.edit_text_password));



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

                startActivity(new Intent(Login.this, SignIn.class));
            }
        });

        bt_login = findViewById(R.id.btn_signin);


        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNum = phonenum.getText().toString();
                String Password = password.getText().toString();

                if(phoneNum.isEmpty() || Password.isEmpty()){
                    Toast.makeText(Login.this, "Please enter your mobile or password", Toast.LENGTH_LONG).show();
                }
                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.hasChild(phoneNum)){

                                String getPass = snapshot.child(phoneNum).child("password").getValue(String.class);

                                if(getPass.equals(Password)){
                                    Toast.makeText(Login.this,"Successfully Logged in", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(Login.this, AppActivity.class);
                                    startActivity(intent);

                                    UserSingleton userSingleton = UserSingleton.getInstance();
                                    userSingleton.setUsername(phoneNum);
                                    userSingleton.setNameimg(phoneNum);
                                }
                                else {
                                    Toast.makeText(Login.this,"Wrong password !", Toast.LENGTH_LONG).show();
                                }
                            }
                            else{
                                Toast.makeText(Login.this,"Wrong Phone Number or Password !", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }

            }
        });
    }
}