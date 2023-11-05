package com.example.cdpm_7meals.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cdpm_7meals.activities.DetailsActivity;
import com.example.cdpm_7meals.R;
import com.example.cdpm_7meals.models.Food;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<Food> ml;

    public FoodAdapter(List<Food> ml) {
        this.ml = ml;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        return new FoodViewHolder(view);
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFood;
        private TextView name,docta,gia;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood =itemView.findViewById(R.id.anh_food);
            name =itemView.findViewById(R.id.name);
            docta =itemView.findViewById(R.id.dacta);
            gia=itemView.findViewById(R.id.gia);

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
