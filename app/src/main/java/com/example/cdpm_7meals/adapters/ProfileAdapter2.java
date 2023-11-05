package com.example.cdpm_7meals.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cdpm_7meals.R;

public class ProfileAdapter2 extends BaseAdapter {
    Context context;
    String List[];

    LayoutInflater inflter;
    public ProfileAdapter2(Context context, String[] List, int[] flags) {
        super();
        this.context = context;
        this.List = List;

        inflter	= (LayoutInflater.from(context));
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
        convertView	=	inflter.inflate(R.layout.list_file, null);
        TextView tieude = (TextView) convertView.findViewById(R.id.tieude);
        tieude.setText(List[position]);
        return convertView;
    }
}
