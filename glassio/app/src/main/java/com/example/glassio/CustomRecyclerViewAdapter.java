package com.example.glassio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter {

    private ArrayList<ListViewData> items;

    public CustomRecyclerViewAdapter(ArrayList<ListViewData> items) {this.items = items;}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_row, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ListViewData item = items.get(position);
        ((CustomViewHolder)holder).name.setText(item.getName());
        ((CustomViewHolder)holder).frame.setText(item.getFrame());
        ((CustomViewHolder)holder).colorr.setText(item.getColorr());
        ((CustomViewHolder)holder).type.setText(item.getType());
        ((CustomViewHolder)holder).image.setImageResource(item.getImage());
        ((CustomViewHolder)holder).price.setText("" + item.getPrice());
    }

    @Override
    public int getItemCount() {
        if(items != null){
            return items.size();
        }
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        protected TextView name;
        protected TextView frame;
        protected TextView colorr;
        protected TextView type;
        protected ImageView image;
        protected TextView price;

        public CustomViewHolder(View view){
            super(view);
            this.name = view.findViewById(R.id.name);
            this.frame = view.findViewById(R.id.frame);
            this.colorr = view.findViewById(R.id.colorr);
            this.type = view.findViewById(R.id.type);
            this.image = view.findViewById(R.id.image);
            this.price = view.findViewById(R.id.price);
        }

    }
}
