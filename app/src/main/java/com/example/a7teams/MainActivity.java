package com.example.a7teams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView rcvFood;
    private Button btRice,btHam,btChick;
    private GridLayoutManager gridLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btRice = findViewById(R.id.btrice);

        btHam=findViewById(R.id.btham);
        btChick=findViewById(R.id.butchick);
        rcvFood =findViewById(R.id.rev);
        gridLayoutManager =new GridLayoutManager(this,2);
        rcvFood.setLayoutManager(gridLayoutManager);
        FoodAdapter adapter =new FoodAdapter(getListFood());
        rcvFood.setAdapter(adapter);

        btHam.setOnClickListener(this);
        btRice.setOnClickListener(this);
        btChick.setOnClickListener(this);
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

            if (v.getId()==R.id.btrice)
        {
            scroollToItem(0);
            btRice.setBackgroundResource(R.drawable.nav);
            btHam.setBackgroundResource(R.drawable.nav2);
            btChick.setBackgroundResource(R.drawable.nav2);
            btChick.setHintTextColor(R.color.og);
            btHam.setHintTextColor(R.color.og);
            btRice.setHintTextColor(R.color.white);
        }
        if (v.getId()==R.id.btham)
        {
            scroollToItem(8);

            btRice.setBackgroundResource(R.drawable.nav2);
            btHam.setBackgroundResource(R.drawable.nav);
            btChick.setBackgroundResource(R.drawable.nav2);
            btChick.setHintTextColor(R.color.og);
            btHam.setHintTextColor(R.color.white);
            btRice.setHintTextColor(R.color.og);


        }
        if (v.getId()==R.id.butchick)
        {
            scroollToItem(10);
            btRice.setBackgroundResource(R.drawable.nav2);
            btHam.setBackgroundResource(R.drawable.nav2);
            btChick.setBackgroundResource(R.drawable.nav);
            btChick.setHintTextColor(R.color.white);
            btHam.setHintTextColor(R.color.og);
            btRice.setHintTextColor(R.color.og);


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