package com.paras.musicapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.paras.musicapp.R;
import com.paras.musicapp.data.pojo.album.Album;
import com.paras.musicapp.ui.AlbumDetailedActivity;
import com.paras.musicapp.ui.GenreActivity;

import java.util.ArrayList;
import java.util.List;

/*
 ** This Class is Used to fetch the data from the POJO Location and bind them to the views.
 **/
public class GenereAdapter extends RecyclerView.Adapter<GenereAdapter.ViewHolder> {

    private List<String> list = new ArrayList<>();
    private Context mContext;
    private int count =9;
    public GenereAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<String> genere){
        list.clear();
        list.addAll(genere);
        notifyDataSetChanged();
    }

    public void setCount(int count){
        this.count =count;
        notifyDataSetChanged();
    }

    /*
     ** inflating the cardView.
     **/
    @Override
    public GenereAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GenereAdapter.ViewHolder holder, int position) {

        String name = list.get(position);
        holder.genre_name.setText(name.substring(0,1).toUpperCase()+name.substring(1));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, GenreActivity.class);
                i.putExtra("GENRE_NAME", name);
                mContext.startActivity(i);
            }
        });
    }

    /*
     ** Last parameter for binding the locations in OnBindViewHolder.
     **/
    @Override
    public int getItemCount() {
        return count;
    }

    /*
     ** ViewHolder class which holds the different views in the recyclerView .
     **/
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView genre_name;

        public ViewHolder(View view) {
            super(view);
            genre_name = itemView.findViewById(R.id.genre_name);
        }


    }
}
