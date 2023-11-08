package com.example.bt4;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Item> listItem;
    private int positionSelect = -1;

    public ItemAdapter(Context context, int idLayout, List<Item> listItem) {
        this.context = context;
        this.idLayout = idLayout;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        if (listItem.size() != 0 && !listItem.isEmpty()) {
            return listItem.size();
        }
        return 0;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        TextView tvLanguageName = (TextView) convertView.findViewById(R.id.tvItemName);
        RelativeLayout layout = (RelativeLayout) convertView.findViewById(R.id.logo);
        final LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.idLinearLayout);
        final Item item = listItem.get(position);

        if (listItem != null && !listItem.isEmpty()) {
            tvLanguageName.setText(item.getName());
            int idItem = item.getId();
            switch (idItem) {
                case 1:
                    layout.setBackgroundResource(R.color.red);
                    break;
                case 2:
                    layout.setBackgroundResource(R.color.purple);
                    break;
                case 3:
                    layout.setBackgroundResource(R.color.blue);
                    break;
                case 4:
                    layout.setBackgroundResource(R.color.yellow);
                    break;
                case 5:
                    layout.setBackgroundResource(R.color.green);
                    break;
                default:
                    break;
            }
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, item.getName(), Toast.LENGTH_LONG).show();
                positionSelect = position;
                notifyDataSetChanged();
            }
        });

        if (positionSelect == position) {
            linearLayout.setBackgroundColor(Color.BLUE);
        } else {
            linearLayout.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }

}
