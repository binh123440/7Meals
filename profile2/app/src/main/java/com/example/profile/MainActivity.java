package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView simpleList;
    String List[] = {"ID", "Giới tính", "Ngày sinh", "Quê quán","Điện thoại"};
    String List2[] = {"99999", "Nam", "21/05/2003", "An Thái, Bình An, Thăng Bình, Quảng Nam","0774515743"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList	=	 (ListView)findViewById(R.id.lvthongtin);
        Adapter adapter	= new com.example.profile.Adapter.Adapter(this, List, List2);
        simpleList.setAdapter((ListAdapter) adapter);
    }
}