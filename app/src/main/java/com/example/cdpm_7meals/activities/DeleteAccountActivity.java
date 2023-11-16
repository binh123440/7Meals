package com.example.cdpm_7meals.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.cdpm_7meals.R;

public class DeleteAccountActivity extends AppCompatActivity {

    private AppCompatButton bt_back;
    private AppCompatButton btxoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);

        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));

        bt_back = findViewById(R.id.back_button);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteAccountActivity.super.onBackPressed();
                onBackPressed();
            }
        });

        btxoa = findViewById(R.id.btxoa);
        btxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenDia(Gravity.CENTER);
            }
        });
    }

    public void OpenDia (int gravity)
    {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogout);
        Window window =dialog.getWindow();
        if(window==null)
        {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams wda= window.getAttributes();
        wda.gravity= gravity;
        window.setAttributes(wda);
        if(Gravity.BOTTOM==gravity)
        {
            dialog.setCancelable(true);

        } else
            dialog.setCancelable(false);
        Button btno = dialog.findViewById(R.id.ko);
        Button btyes = dialog.findViewById(R.id.co);
        btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                startActivity(new Intent(DeleteAccountActivity.this, IntroActivity.class));
            }
        });
        dialog.show();
    }
}