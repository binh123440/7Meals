package com.example.cdpm_7meals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


public class ListProduct extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView rcvFood;
    private Button btRice,btHam,btChick;
    private GridLayoutManager gridLayoutManager;

    private ImageButton bt_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);
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