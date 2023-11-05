package com.example.cdpm_7meals.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.models.Food;
import com.example.cdpm_7meals.adapters.FoodAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListProduct extends AppCompatActivity {

    private RecyclerView rcvFood;
    private Button btRice,btHam,btChick;
    private GridLayoutManager gridLayoutManager;
    private ImageButton bt_back;

    private RelativeLayout card_food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));

        btRice = findViewById(R.id.bt_rice);
        btHam = findViewById(R.id.bt_ham);
        btChick = findViewById(R.id.bt_chicken);
        rcvFood = findViewById(R.id.rev);
        gridLayoutManager = new GridLayoutManager(ListProduct.this,2);
        rcvFood.setLayoutManager(gridLayoutManager);
        FoodAdapter adapter = new FoodAdapter(getListFood());
        rcvFood.setAdapter(adapter);

        btRice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickCategory(view);
                Unclick(btHam);
                Unclick(btChick);
            }
        });

        btHam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickCategory(view);
                Unclick(btRice);
                Unclick(btChick);
            }
        });

        btChick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickCategory(view);
                Unclick(btRice);
                Unclick(btHam);
            }
        });

        bt_back = findViewById(R.id.back_white);
        bt_back.setOnClickListener(view -> {
            super.onBackPressed();
            onBackPressed();
        });
    }



    private List<Food> getListFood()
    {
        List<Food> list = new ArrayList<>();
        list.add(new Food(R.drawable.fried_chicken_and_fried_rice_1,"Egg fried rice with chicken","Made from fried rice with eggs and served with fried chicken",80000,Food.Rice));
        list.add(new Food(R.drawable.fried_chicken_and_fried_rice,"Fried rice with fried chicken and fat","Made from rice and chicken coated with fat for grilling",50000,Food.Rice));
        list.add(new Food(R.drawable.burger,"Beef Burger with special sauce","With a sauce made from a blend of cream and cheese, it creates a burger with a bold Asian flavor",50000,Food.Ham));
        list.add(new Food(R.drawable.chicken_burger,"Burger Chicken","A normal burger but the main ingredient is fried chicken",50000,Food.Ham));
        list.add(new Food(R.drawable.fried_chicken,"Fried chicken thighs","Plump chicken thighs are soaked in egg and rolled in breadcrumbs",135000,Food.Chicken));
        list.add(new Food(R.drawable.chicken_satay,"Grilled chicken wings with satay","Grilled with satay gives it a flavor that is both spicy and salty",135000,Food.Chicken));
        list.add(new Food(R.drawable.fried_chicken_and_fried_rice_1,"Egg fried rice with chicken","Made from fried rice with eggs and served with fried chicken",80000,Food.Rice));
        list.add(new Food(R.drawable.fried_chicken_and_fried_rice,"Fried rice with fried chicken and fat","Made from rice and chicken coated with fat for grilling",50000,Food.Rice));
        list.add(new Food(R.drawable.burger,"Beef Burger with special sauce","With a sauce made from a blend of cream and cheese, it creates a burger with a bold Asian flavor",50000,Food.Ham));
        list.add(new Food(R.drawable.chicken_burger,"Burger Chicken","A normal burger but the main ingredient is fried chicken",50000,Food.Ham));
        list.add(new Food(R.drawable.fried_chicken,"Fried chicken thighs","Plump chicken thighs are soaked in egg and rolled in breadcrumbs",135000,Food.Chicken));
        list.add(new Food(R.drawable.chicken_satay,"Grilled chicken wings with satay","Grilled with satay gives it a flavor that is both spicy and salty",135000,Food.Chicken));
        return list;
    }

    public void Unclick(View v){
        Button btn = (Button) v;
        int textColor = ContextCompat.getColor(v.getContext(), R.color.yellow2);
        btn.setTextColor(textColor);
        btn.setBackground(getResources().getDrawable(R.drawable.bounder_btn_yellow));
    }

    public void handleClickCategory(View v){
        Button btn = (Button) v;
        int textColor = ContextCompat.getColor(v.getContext(), R.color.white);
        btn.setTextColor(textColor);
        btn.setBackground(getResources().getDrawable(R.drawable.bounder_btn_category_hover));
    };

    @SuppressLint("ResourceAsColor")
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