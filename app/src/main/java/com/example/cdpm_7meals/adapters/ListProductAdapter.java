package com.example.cdpm_7meals.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.activities.DetailsActivity;
import com.example.cdpm_7meals.models.Food;
import com.example.cdpm_7meals.models.Product;
import com.example.cdpm_7meals.models.Product2;

import java.util.List;
public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.FoodViewHolder> {
    private List<Product2> ml;
    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Product2> ml) {
        this.ml = ml;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new FoodViewHolder(view);
    }
    public class FoodViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFood;
        private TextView name, docta, gia;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.anh_food);
            name = itemView.findViewById(R.id.name);
            docta = itemView.findViewById(R.id.dacta);
            gia = itemView.findViewById(R.id.gia);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Product2 it = ml.get(position);
        if (it == null) {
            return;
        }
        Glide.with(holder.itemView.getContext())
                .load(it.getImage())
                .into(holder.imgFood);
        holder.name.setText(it.getName());
        holder.docta.setText(it.getDesc());
        holder.gia.setText(it.getPrice() / 1000 + ".000 VND");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                intent.putExtra("imgResource", it.getImage());
                intent.putExtra("name", it.getName());
                intent.putExtra("dacta", it.getDesc());
                intent.putExtra("gia", it.getPrice());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        if (ml != null) {
            return ml.size();
        }
        return 0;
    }


}
