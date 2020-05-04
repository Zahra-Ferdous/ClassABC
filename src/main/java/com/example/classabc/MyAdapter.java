package com.example.classabc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {



    private static ClickListener click;

    Context context;
    String[] names;
    int[] images;
    String[] rolls;


    public MyAdapter(Context context, String[] names, int[] images ,String[] rolls) {
        this.context = context;
        this.names = names;
        this.images = images;
        this.rolls = rolls;
    }

    public MyAdapter(){

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater linflater = LayoutInflater.from(context);
        View view = linflater.inflate(R.layout.sample_recyclerview,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.nameV.setText(names[position]);
        holder.rollV.setText(rolls[position]);
        holder.proV.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener , View.OnLongClickListener {

        TextView nameV, rollV;
        ImageView proV;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            nameV = itemView.findViewById(R.id.recyler_name);
            rollV = itemView.findViewById(R.id.recyler_roll);
            proV = itemView.findViewById(R.id.recyler_imageId);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            click.onItemClick(getAdapterPosition(),v);
        }

        @Override
        public boolean onLongClick(View v) {
            click.onLongItemClick(getAdapterPosition(),v);
            return false;
        }
    }

    public interface ClickListener{
        void onItemClick(int position,View view);
        void onLongItemClick(int position,View view);
    }

    public void setOnItemClickListener(ClickListener click){
        MyAdapter.click = click;

    }
}

