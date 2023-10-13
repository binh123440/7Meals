package com.example.cdpm_7meals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class HomePage extends AppCompatActivity {

    private AppCompatButton bt_all;
    private ViewPager2 viewPager2;

    //implementing auto slide facility
    private Handler slideHandler = new Handler();

    private MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.icon_home_bottom_navigation));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.icon_cart_bottom_navigation));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.icon_profile_bottom_navigation));

        bottomNavigation.show(1,true);

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES
                switch (model.getId()){
                    case 1:
                        //Đối với những máy sử dụng các phím đa nhiệm chứ ko phải vuốt màn hình để thao tác thì sử dụng
                        //2 hàm bên dưới sẽ set bottomnavi và các nút đa nhiệm cùng màu
                        getWindow().setNavigationBarColor(Color.parseColor("#FDB222"));
                        bottomNavigation.setBackgroundBottomColor(Color.parseColor("#FDB222"));
                        //status là thanh ở trên
                        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));
                        break;
                    case 2:
                        getWindow().setNavigationBarColor(Color.parseColor("#FDB222"));
                        bottomNavigation.setBackgroundBottomColor(Color.parseColor("#FDB222"));
                        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));
                        break;
                    case 3:
                        getWindow().setNavigationBarColor(Color.parseColor("#FDB222"));
                        bottomNavigation.setBackgroundBottomColor(Color.parseColor("#FDB222"));
                        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));
                        break;
                }
                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES
                switch (model.getId()){
                    case 1:
                        getWindow().setNavigationBarColor(Color.parseColor("#FDB222"));
                        bottomNavigation.setBackgroundBottomColor(Color.parseColor("#FDB222"));
                        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));
                        break;
                    case 2:
                        getWindow().setNavigationBarColor(Color.parseColor("#FDB222"));
                        bottomNavigation.setBackgroundBottomColor(Color.parseColor("#FDB222"));
                        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));
                        break;
                    case 3:
                        getWindow().setNavigationBarColor(Color.parseColor("#FDB222"));
                        bottomNavigation.setBackgroundBottomColor(Color.parseColor("#FDB222"));
                        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));
                        break;
                }
                return null;
            }
        });

        bt_all = findViewById(R.id.button_all);
        bt_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this,ListProduct.class);
                startActivity(intent);
            }
        });

        viewPager2 = findViewById(R.id.slide_show_home_page);

        List<SlideItem> slideItemList = new ArrayList<>();

        slideItemList.add(new SlideItem(R.drawable.banner_2));
        slideItemList.add(new SlideItem(R.drawable.banner_1));
        slideItemList.add(new SlideItem(R.drawable.banner_2));

        viewPager2.setAdapter(new SlideAdapter(slideItemList,viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(30));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);

            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        Runnable sliderRunnable = new Runnable() {
            @Override
            public void run() {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        };
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                slideHandler.removeCallbacks(sliderRunnable);
                slideHandler.postDelayed(sliderRunnable,4000);
            }
        });

    }
}