package com.example.cdpm_7meals.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.fragments.AdminFragment;
import com.example.cdpm_7meals.fragments.CartFragment;
import com.example.cdpm_7meals.fragments.HomeFragment;
import com.example.cdpm_7meals.fragments.ProfileFragment;
import com.example.cdpm_7meals.fragments.TestFragment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class AppActivity extends AppCompatActivity {

    private MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        CreateBottomNavigation();
    }

    protected void CreateBottomNavigation() {
        final int HOME = 1;
        final int CART = 2;
        final int PROFILE = 3;
        final int ADMIN = 4;

        bottomNavigation = findViewById(R.id.MeowBottomNavigation);
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.icon_home_bottom_navigation));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.icon_cart_bottom_navigation));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.icon_profile_bottom_navigation));

        bottomNavigation.setBackgroundBottomColor(Color.parseColor("#FDB222"));
        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));

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

        bottomNavigation.setOnClickMenuListener(item -> {
            return null;
        });

        bottomNavigation.setOnShowListener(item -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.App,
                            item.getId() == HOME ? HomeFragment.class
                                    : (item.getId() == CART ? CartFragment.class
                                    : item.getId() == PROFILE ? ProfileFragment.class
                                    : AdminFragment.class)
                            , null)
                    .commit();
            return Unit.INSTANCE;
        });

        bottomNavigation.setOnReselectListener(item -> {
            return null;
        });

        bottomNavigation.show(HOME, false);
    }
}