package com.example.cdpm_7meals.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.adapters.HistoryAdapter;
import com.example.cdpm_7meals.models.Food;
import com.example.cdpm_7meals.models.History;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryFragment {
    RecyclerView rcv_history;
    GridLayoutManager gridLayoutManager;


    public void onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle saveInstance) {
        View view =  inflater.inflate(R.layout.history_layout, viewGroup, false);
        rcv_history = view.findViewById(R.id.rcv_item_history);
        gridLayoutManager = new GridLayoutManager(inflater.getContext(), 1);
        rcv_history.setLayoutManager(gridLayoutManager);
    }

    private List<Food> getListHistory()
    {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        List<History> list = new ArrayList<>();
        list.add(new History(1,R.drawable.fried_chicken,"28-09-2020 10:00:00"))
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
}
