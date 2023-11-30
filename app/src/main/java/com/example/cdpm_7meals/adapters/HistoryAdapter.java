package com.example.cdpm_7meals.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.models.History;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    private List<History> listHistory;

    public HistoryAdapter(List<History> listHistory) {
        this.listHistory = listHistory;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history,parent,false);
        return new HistoryViewHolder(view);
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView id,date,name,qtt,price;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image_history);
            id = itemView.findViewById(R.id.tv_order1);
            date = itemView.findViewById(R.id.tv_date_order1);
            name = itemView.findViewById(R.id.name_product1);
            qtt = itemView.findViewById(R.id.qtt1);
            price = itemView.findViewById(R.id.price_number_product1);
        }
    }

    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        History history = listHistory.get(position);
        if (history == null) {
            return;
        }
        holder.img.setImageResource(history.getImage());
        holder.id.setText("Order ID: 00" + history.getId());

        //Chuyển date sang String
        //Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateString = dateFormat.format(history.getOrderDay());
        holder.date.setText("Date: " + dateString);
        holder.name.setText(history.getName());
        holder.qtt.setText(history.getQuantity());
        holder.price.setText(history.getPrice() + " VND");
    }

    @Override
    public int getItemCount() {
        if(listHistory != null)
        {
            return listHistory.size();
        }
        return 0;
    }
}
