package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.profile.Adapter.ProfileAdapter;

public class profilemain extends AppCompatActivity {
    ListView list;
    String List[] = {"Profile","Request account deletion","Terms and Policies","Log out"};
    int flags[]={R.drawable.iconavatar,R.drawable.caidat,R.drawable.warningoctagon,R.drawable.signout};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilemain);
        list =(ListView) findViewById(R.id.list);
        ProfileAdapter adapter = new ProfileAdapter(profilemain.this,List,flags);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0: Intent myintent = new Intent(profilemain.this, profile.class);
                        startActivity(myintent);break;
                    case 1: Intent myintent2 = new Intent(profilemain.this, Xoataikhoan.class);
                        startActivity(myintent2);break;
                    case 2: Intent myintent3 = new Intent(profilemain.this, Dieukhoan.class);
                        startActivity(myintent3);break;
                    case 3: OpenDia(Gravity.CENTER); break;


                }


            }
        });

    }
    public void OpenDia (int gravity)
    {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.tbdangxuat);
        Window window =dialog.getWindow();
        if(window==null)
        {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams wda= window.getAttributes();
        wda.gravity= gravity;
        window.setAttributes(wda);
        if(Gravity.BOTTOM==gravity)
        {
            dialog.setCancelable(true);

        } else
            dialog.setCancelable(false);
        Button btno = dialog.findViewById(R.id.btno);
        Button btyes = dialog.findViewById(R.id.btyes);
        btno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}