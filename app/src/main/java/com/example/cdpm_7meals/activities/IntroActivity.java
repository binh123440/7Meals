package com.example.cdpm_7meals.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.data.Data;

import java.util.Date;

//"34ef7473-57db-4f1c-9421-ef824de2750d"
public class IntroActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME = 5000;

    Date date;
    Animation topAnima, bottomAnima;
    ImageView logo, brand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCenter.start(getApplication(), "{Your app secret here}",
                Analytics.class, Crashes.class);
        super.onCreate(savedInstanceState);

        // full screen at intro
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.intro);

        new Data().Add_Data_Nam();
        new Data().Add_Data_Binh();
        new Data().Add_Data_Food();

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