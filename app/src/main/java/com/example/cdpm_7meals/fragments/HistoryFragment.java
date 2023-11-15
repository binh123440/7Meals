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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryFragment {
    RecyclerView rcv_history;
    GridLayoutManager gridLayoutManager;
    Date date;


    public void onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle saveInstance) {
        View view =  inflater.inflate(R.layout.history_layout, viewGroup, false);
        rcv_history = view.findViewById(R.id.rcv_item_history);
        gridLayoutManager = new GridLayoutManager(inflater.getContext(), 1);
        rcv_history.setLayoutManager(gridLayoutManager);
    }

    private List<History> getListHistory() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        List<History> list = new ArrayList<>();

        try{
            date = df.parse("28-09-2020 10:00:00");
            list.add(new History(1,R.drawable.fried_chicken,date,"Egg fried rice with chicken",3,80000));
            date = df.parse("28-09-2021 10:00:00");
            list.add(new History(1,R.drawable.fried_chicken,date,"Egg fried rice with chicken",3,80000));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }
}
