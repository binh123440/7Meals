package com.example.cdpm_7meals.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.SlideAdapter;
import com.example.cdpm_7meals.SlideItem;
import com.example.cdpm_7meals.activities.ListProduct;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    AppCompatButton bt_all,bt_rice,bt_ham,bt_chicken;
    ViewPager2 viewPager2;
    TextView tv_topTheWeek;

    //implementing auto slide facility
    Handler slideHandler = new Handler();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_home, container, false);


        tv_topTheWeek = view.findViewById(R.id.text_top_the_week);

        bt_all = view.findViewById(R.id.button_all);
        bt_rice = view.findViewById(R.id.button_rice);
        bt_ham = view.findViewById(R.id.button_ham);
        bt_chicken = view.findViewById(R.id.button_chicken);
        bt_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickCategory(view);
                Unclick(bt_rice);
                Unclick(bt_ham);
                Unclick(bt_chicken);
                tv_topTheWeek.setText("Top The Week");

                startActivity(new Intent(getContext(), ListProduct.class));
            }
        });

        bt_rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickCategory(view);
                Unclick(bt_all);
                Unclick(bt_ham);
                Unclick(bt_chicken);
                tv_topTheWeek.setText("Rice");
            }
        });

        bt_ham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickCategory(view);
                Unclick(bt_rice);
                Unclick(bt_all);
                Unclick(bt_chicken);
                tv_topTheWeek.setText("Hambuger");
            }
        });

        bt_chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickCategory(view);
                Unclick(bt_rice);
                Unclick(bt_ham);
                Unclick(bt_all);
                tv_topTheWeek.setText("Chicken");
            }
        });

        viewPager2 = view.findViewById(R.id.slide_show_home_page);

        List<SlideItem> slideItemList = new ArrayList<>();

        slideItemList.add(new SlideItem(R.drawable.banner_2));
        slideItemList.add(new SlideItem(R.drawable.banner_1));
        slideItemList.add(new SlideItem(R.drawable.banner_2));

        viewPager2.setAdapter(new SlideAdapter(slideItemList,viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(30));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);

            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        Runnable sliderRunnable = new Runnable() {
            @Override
            public void run() {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        };
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                slideHandler.removeCallbacks(sliderRunnable);
                slideHandler.postDelayed(sliderRunnable,4000);
            }
        });

        // Inflate the layout for this fragment
        return view;
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
    }
}