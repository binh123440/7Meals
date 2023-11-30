package com.example.cdpm_7meals.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.adapters.ListProductAdapter;
import com.example.cdpm_7meals.models.Food;
import com.example.cdpm_7meals.adapters.FoodAdapter;
import com.example.cdpm_7meals.models.Product;
import com.example.cdpm_7meals.models.Product2;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListProduct extends AppCompatActivity {
    private RecyclerView rcvFood;
    private Button btRice, btHam, btChick;
    private GridLayoutManager gridLayoutManager;
    private ImageButton bt_back;

    private RelativeLayout card_food;
    private ListProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        getWindow().setStatusBarColor(Color.parseColor("#FDB222"));

        btRice = findViewById(R.id.bt_rice);
        btHam = findViewById(R.id.bt_ham);
        btChick = findViewById(R.id.bt_chicken);
        rcvFood = findViewById(R.id.rev);
        gridLayoutManager = new GridLayoutManager(ListProduct.this, 2);
        rcvFood.setLayoutManager(gridLayoutManager);
        adapter = new ListProductAdapter();
        rcvFood.setAdapter(adapter);
        getAllData();
        btRice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickCategory(view,1);
                Unclick(btHam);
                Unclick(btChick);
            }
        });
        btHam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickCategory(view,2);
                Unclick(btRice);
                Unclick(btChick);
            }
        });
        btChick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickCategory(view,3);
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
    public void Unclick(View v) {
        Button btn = (Button) v;
        int textColor = ContextCompat.getColor(v.getContext(), R.color.yellow2);
        btn.setTextColor(textColor);
        btn.setBackground(ContextCompat.getDrawable(v.getContext(),R.drawable.bounder_btn_yellow));
    }
    public void handleClickCategory(View v, int key) {
        Button btn = (Button) v;
        int textColor = ContextCompat.getColor(v.getContext(), R.color.white);
        btn.setTextColor(textColor);
        btn.setBackground(ContextCompat.getDrawable(v.getContext(),R.drawable.bounder_btn_category_hover));
        getData(key);
    }
    private void getAllData(){
        firebaseDatabase.getReference("listProduct")
                .get()
                .addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
                    @Override
                    public void onSuccess(DataSnapshot dataSnapshot) {
                        if (isFinishing() || isDestroyed()){
                            return;
                        }
                        for (DataSnapshot it : dataSnapshot.getChildren()) {
                            Product2 product = it.getValue(Product2.class);
                            list.add(product);
                            Log.d("__image", "onDataChange: "+product.getImage());
                        }
                        adapter.setData(list);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (isFinishing() || isDestroyed()){
                            return;
                        }
                        Toast.makeText(ListProduct.this, "Lỗi", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    private List<Product2> list = new ArrayList<>();
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    private void getData(int key) {
        list.clear();
        Query query = firebaseDatabase.getReference("listProduct");
        query.orderByChild("categoryID").equalTo(key)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (isFinishing() || isDestroyed()){
                            return;
                        }
                        for (DataSnapshot it : snapshot.getChildren()) {
                            Product2 product = it.getValue(Product2.class);
                            list.add(product);
                            Log.d("__image", "onDataChange: "+product.getImage());
                        }
                        adapter.setData(list);
                        Log.d("__index", "__index"+list.size());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        if (isFinishing() || isDestroyed()){
                            return;
                        }
                        Log.d("__index", "__index"+error.getMessage().toString());
                    }
                });
    }
    @SuppressLint("ResourceAsColor")
    public void onClick(View v) {

        if (v.getId() == R.id.bt_rice) {
            scroollToItem(0);
            btRice.setBackgroundResource(R.drawable.nav);
            btHam.setBackgroundResource(R.drawable.nav2);
            btChick.setBackgroundResource(R.drawable.nav2);
            btChick.setHintTextColor(R.color.orange);
            btHam.setHintTextColor(R.color.orange);
            btRice.setHintTextColor(R.color.white);
        }
        if (v.getId() == R.id.bt_ham) {
            scroollToItem(8);
            btRice.setBackgroundResource(R.drawable.nav2);
            btHam.setBackgroundResource(R.drawable.nav);
            btChick.setBackgroundResource(R.drawable.nav2);
            btChick.setHintTextColor(R.color.orange);
            btHam.setHintTextColor(R.color.white);
            btRice.setHintTextColor(R.color.orange);
        }
        if (v.getId() == R.id.bt_chicken) {
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
        if (gridLayoutManager == null) {
            return;
        }
        gridLayoutManager.scrollToPositionWithOffset(i, 0);
    }
}