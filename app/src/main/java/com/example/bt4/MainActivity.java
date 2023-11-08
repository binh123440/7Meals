package com.example.bt4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Item> listItem;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvItem);
        listItem = new ArrayList<>();
        listItem.add(new Item(1,"Màu đỏ"));
        listItem.add(new Item(2,"Màu tím"));
        listItem.add(new Item(3,"Màu xanh dương"));
        listItem.add(new Item(4,"Màu vàng"));
        listItem.add(new Item(5,"Màu xanh lục"));

        ItemAdapter adapter = new ItemAdapter(this, R.layout.listview_item,listItem);
        lv.setAdapter(adapter);
    }
}