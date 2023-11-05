package com.example.cdpm_7meals.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cdpm_7meals.R;

public class ProfileAdapter extends BaseAdapter {

    Context context;
    String List[];
    int flags[];
    LayoutInflater inflter;

    public ProfileAdapter(Context context, String[] list, int[] flags) {
        this.context = context;
        List = list;
        this.flags = flags;
        inflter = (LayoutInflater.from(context)) ;
    }

    @Override
    public int getCount() {
        return List.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView =inflter.inflate(R.layout.card_file,null);
        TextView text =(TextView)convertView.findViewById(R.id.texta);
        ImageView img =(ImageView) convertView.findViewById(R.id.imgicon);
        text.setText(List[position]);
        img.setImageResource(flags[position]);
        return convertView;
    }
}
