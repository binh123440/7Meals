package com.example.cdpm_7meals.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.models.UserHelperClass;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignIn extends AppCompatActivity {


    TextInputLayout firstname, lastname, phonenum, gender, birthday, address , password;
    private TextView btn_back;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    private AppCompatButton btn_signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);




        getWindow().setNavigationBarColor(Color.parseColor("#FDB222"));
        //status là thanh ở trên
        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));

        firstname = findViewById(R.id.FirstNamelay);
        lastname = findViewById(R.id.LastNamelay);
        phonenum = findViewById(R.id.phoneNumberlay2);
        gender = findViewById(R.id.GenderLay);
        birthday = findViewById(R.id.BirthdayLay);
        address = findViewById(R.id.AddressLay);
        password = findViewById((R.id.enterPasswordLayout));

        btn_back = findViewById(R.id.nutback);



        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this, Login.class));
            }
        });

        btn_signin = findViewById(R.id.nutSignin);

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");

                //get all value
                String firstName = firstname.getEditText().getText().toString();
                String lastName = lastname.getEditText().getText().toString();
                String phoneNum = phonenum.getEditText().getText().toString();
                String Gender = gender.getEditText().getText().toString();
                String Birthday = birthday.getEditText().getText().toString();
                String Address = address.getEditText().getText().toString();
                String Password = password.getEditText().getText().toString();
                UserHelperClass helperClass = new UserHelperClass(firstName, lastName, phoneNum, Gender, Birthday, Address, Password);
                reference.child(phoneNum).setValue(helperClass);

                startActivity(new Intent(SignIn.this, AppActivity.class));
            }
        });
    }
}