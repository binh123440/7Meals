package com.example.cdpm_7meals.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.cdpm_7meals.R;
import com.squareup.picasso.Picasso;

public class ShowImage extends AppCompatActivity {

    private ImageView img;
    private ImageButton bt_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        img = findViewById(R.id.img_choose);
        bt_back = findViewById(R.id.back_white);

        Intent intent = getIntent();
        if (intent != null) {
            String imgString = intent.getStringExtra("img");
            Uri imgUri = Uri.parse(imgString);
            Picasso.get().load(imgUri).into(img);
        }

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowImage.this, SignIn.class));
            }
        });
    }
}