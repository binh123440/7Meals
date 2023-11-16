package com.example.cdpm_7meals.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.activities.DetailsActivity;
import com.example.cdpm_7meals.models.Food;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class FoodAdapter2 extends RecyclerView.Adapter<FoodAdapter2.FoodViewHolder> {
    private List<Food> ml;

    public FoodAdapter2(List<Food> ml) {
        this.ml = ml;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);
        return new FoodViewHolder(view);
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFood;
        private TextView name,docta,gia;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.imgSource);
            name = itemView.findViewById(R.id.name_product1);
            docta = itemView.findViewById(R.id.des_product1);
            gia = itemView.findViewById(R.id.price_product_1);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = ml.get(position);
        if(food==null)
        {
            return;
        }
        holder.imgFood.setImageResource(food.getImage());
        holder.name.setText(food.getName());
        holder.docta.setText(food.getDacta());
        holder.gia.setText(food.getGia()/1000 + "." + "000" + " VND");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
                intent.putExtra("imgResource",food.getImage());
                intent.putExtra("name",food.getName());
                intent.putExtra("dacta",food.getDacta());
                intent.putExtra("gia",food.getGia());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(ml!=null)
        {
            return ml.size();
        }
        return 0;
    }


}
