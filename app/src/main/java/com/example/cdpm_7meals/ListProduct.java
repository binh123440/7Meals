package com.example.cdpm_7meals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;


public class ListProduct extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView rcvFood;
    private Button btRice,btHam,btChick;
    private GridLayoutManager gridLayoutManager;

    private ImageButton bt_back;

    private MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

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

        btRice = findViewById(R.id.bt_rice);
        btHam=findViewById(R.id.bt_ham);
        btChick=findViewById(R.id.bt_chicken);
        rcvFood =findViewById(R.id.rev);
        gridLayoutManager =new GridLayoutManager(this,2);
        rcvFood.setLayoutManager(gridLayoutManager);
        FoodAdapter adapter =new FoodAdapter(getListFood());
        rcvFood.setAdapter(adapter);

        btHam.setOnClickListener(this);
        btRice.setOnClickListener(this);
        btChick.setOnClickListener(this);
        bt_back = findViewById(R.id.back_white);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListProduct.this,HomePage.class);
                startActivity(intent);
            }
        });
    }
    private List<Food> getListFood()
    {
        List<Food> list =new ArrayList<>();
        list.add(new Food(R.drawable.product_1_1,"Cơm","Cơm not rice","100 tỷ",Food.Rice));
        list.add(new Food(R.drawable.product_1_1,"Cơm","Cơm not rice","100 tỷ",Food.Rice));
        list.add(new Food(R.drawable.product_1_1,"Cơm","Cơm not rice","100 tỷ",Food.Rice));
        list.add(new Food(R.drawable.product_1_1,"Cơm","Cơm not rice","100 tỷ",Food.Rice));
        list.add(new Food(R.drawable.product_1_1,"Cơm","Cơm not rice","100 tỷ",Food.Rice));
        list.add(new Food(R.drawable.product_1_1,"Cơm","Cơm not rice","100 tỷ",Food.Rice));
        list.add(new Food(R.drawable.product_1_1,"Cơm","Cơm not rice","100 tỷ",Food.Rice));
        list.add(new Food(R.drawable.product_1_1,"Cơm","Cơm not rice","100 tỷ",Food.Ham));
        list.add(new Food(R.drawable.product_1_1,"Cơm","Cơm not rice","100 tỷ",Food.Ham));
        list.add(new Food(R.drawable.product_1_1,"Cơm","Cơm not rice","100 tỷ",Food.Chicken));
        list.add(new Food(R.drawable.product_1_1,"Cơm","Cơm not rice","100 tỷ",Food.Chicken));
        return  list;
    }



    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.bt_rice)
        {
            scroollToItem(0);
            btRice.setBackgroundResource(R.drawable.nav);
            btHam.setBackgroundResource(R.drawable.nav2);
            btChick.setBackgroundResource(R.drawable.nav2);
            btChick.setHintTextColor(R.color.orange);
            btHam.setHintTextColor(R.color.orange);
            btRice.setHintTextColor(R.color.white);
        }
        if (v.getId()==R.id.bt_ham)
        {
            scroollToItem(8);

            btRice.setBackgroundResource(R.drawable.nav2);
            btHam.setBackgroundResource(R.drawable.nav);
            btChick.setBackgroundResource(R.drawable.nav2);
            btChick.setHintTextColor(R.color.orange);
            btHam.setHintTextColor(R.color.white);
            btRice.setHintTextColor(R.color.orange);


        }
        if (v.getId()==R.id.bt_chicken)
        {
            scroollToItem(10);
            btRice.setBackgroundResource(R.drawable.nav2);
            btHam.setBackgroundResource(R.drawable.nav2);
            btChick.setBackgroundResource(R.drawable.nav);
            btChick.setHintTextColor(R.color.white);
            btHam.setHintTextColor(R.color.orange);
            btRice.setHintTextColor(R.color.orange);


        }

    }

    private void scroollToItem(int i) {
        if(gridLayoutManager==null)
        {
            return;
        }
        gridLayoutManager.scrollToPositionWithOffset(i,0);
    }
}