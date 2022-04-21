package com.example.javamaps.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javamaps.databinding.RecrowViewBinding;
import com.example.javamaps.model.Place;
import com.example.javamaps.view.MapsActivity;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceHolder> {

    List<Place> placeList;

    public PlaceAdapter(List<Place> placeList) {
        this.placeList = placeList;
    }

    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecrowViewBinding recrowViewBinding=RecrowViewBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PlaceHolder(recrowViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.recrowViewBinding.recTextView.setText(placeList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(), MapsActivity.class);
                intent.putExtra("info","old");
                intent.putExtra("place",placeList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    public class PlaceHolder extends RecyclerView.ViewHolder{

        RecrowViewBinding recrowViewBinding;

        public PlaceHolder(@NonNull RecrowViewBinding recrowViewBinding) {
            super(recrowViewBinding.getRoot());
            this.recrowViewBinding=recrowViewBinding;
        }
    }
}
