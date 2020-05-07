package com.example.sportapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sportapi.R;
import com.example.sportapi.model.sport.ResultItem;

import java.util.ArrayList;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ViewHolder>{
    private ArrayList<ResultItem> teamsItems = new ArrayList<>();
    private Context context;

    private static String BASE_IMAGE_URL = "https://allsportsapi.com/logo/";

    public SportAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<ResultItem> items){
        teamsItems.clear();
        teamsItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SportAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(BASE_IMAGE_URL+teamsItems.get(position)
                .getTeamLogo())
                .into(holder.ivThumb);

        holder.tvLive.setText(teamsItems.get(position).getTeamKey());

    }

    @Override
    public int getItemCount() {
        return teamsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumb;
        TextView tvLive;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            ivThumb = itemView.findViewById(R.id.itemlist_iv_thumbnail);
            tvLive = itemView.findViewById(R.id.itemlist_tv_title);
        }
    }
}
