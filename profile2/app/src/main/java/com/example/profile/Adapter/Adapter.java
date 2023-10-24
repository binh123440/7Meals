package com.example.profile.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.profile.R;

public class Adapter extends BaseAdapter{
    Context context;
    String List[],List2[];

    LayoutInflater inflter;
    public Adapter(Context context, String[] List, String List2[]) {
        super();
        this.context = context;
        this.List = List;
        this.List2=List2;
        inflter	= (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return List.length;
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        convertView	=	inflter.inflate(R.layout.cardthongtin, null);
        TextView text1 = (TextView) convertView.findViewById(R.id.txst);
        TextView text2 = (TextView) convertView.findViewById(R.id.tvcard);

        text1.setText(List[position]);
        text2.setText(List2[position]);
        return convertView;
    }
}