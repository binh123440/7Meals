package com.example.cdpm_7meals.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.data.Data;
import com.example.cdpm_7meals.data.UpData;
import com.example.cdpm_7meals.models.Profile;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class IntroActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME = 5000;

    Date date;
    Animation topAnima, bottomAnima;
    ImageView logo, brand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // full screen at intro
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.intro);

        new Data().Add_ProfileData();

        // load animation
        topAnima = AnimationUtils.loadAnimation(this, R.anim.top_icon_animation);
        bottomAnima = AnimationUtils.loadAnimation(this, R.anim.bot_logan_animation);

        // set animation
        logo = findViewById(R.id.img_icon_intro);
        brand = findViewById(R.id.img_slogan_intro);
        logo.setAnimation(topAnima);
        brand.setAnimation(bottomAnima);

        // next to intro2
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(IntroActivity.this, Login.class));
                finish();
            }
        }, SPLASH_SCREEN_TIME);
    }
}