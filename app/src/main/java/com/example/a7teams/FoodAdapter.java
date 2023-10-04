package com.example.a7teams;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
            Food food = ml.get(position);
            if(food==null)
            {
                return;
            }
            holder.imgFood.setImageResource(food.getImage());
            holder.name.setText(food.getName());
            holder.docta.setText(food.getDocta());
            holder.gia.setText(food.getGia());
    }

    @Override
    public int getItemCount() {
        if(ml!=null)
        {
            return ml.size();
        }
        return 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFood;
        private TextView name,docta,gia;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood =itemView.findViewById(R.id.anhfood);
            name =itemView.findViewById(R.id.name);
            docta =itemView.findViewById(R.id.docta);
            gia=itemView.findViewById(R.id.gia);

        }
    }
}
