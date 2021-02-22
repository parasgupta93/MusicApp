package com.paras.musicapp.ui.adapter;

import android.content.Context;
import android.content.Intent;
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

import java.util.ArrayList;
import java.util.List;

/*
** This Class is Used to fetch the data from the POJO Location and bind them to the views.
**/
public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List<Album> list = new ArrayList<Album>();
    private Context mContext;

    public AlbumAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Album> albumArrayList){
        list.clear();
        list.addAll(albumArrayList);
        notifyDataSetChanged();
    }
    /*
    ** inflating the cardView.
    **/
    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.common_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlbumAdapter.ViewHolder holder, int position) {

        String albumName = list.get(position).getName();
        String albumArtistName = list.get(position).getAlbumArtist().getName();
        String cover = list.get(position).getImage().get(3).getText();
        holder.album_artist.setText(albumArtistName);
        holder.album_name.setText(albumName);

        Glide.with(mContext)
                .load(cover)
                .thumbnail(0.1f)
                .centerCrop()
                .error(R.drawable.not_found)
                .into(holder.album_cover);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, AlbumDetailedActivity.class);
                i.putExtra("ALBUM_NAME", albumName);
                i.putExtra("ALBUM_COVER", cover);
                i.putExtra("ARTIST_NAME", albumArtistName);
                mContext.startActivity(i);
            }
        });
    }

    /*
    ** Last parameter for binding the locations in OnBindViewHolder.
    **/
    @Override
    public int getItemCount() {
        return list.size();
    }

    /*
    ** ViewHolder class which holds the different views in the recyclerView .
    **/
    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView album_name;
        TextView album_artist;
        ImageView album_cover;

        public ViewHolder(View view) {
            super(view);
            cardView = itemView.findViewById(R.id.card_view);
            album_cover = itemView.findViewById(R.id.cover);
            album_name = itemView.findViewById(R.id.name);
            album_artist = itemView.findViewById(R.id.artist_name);
        }


    }
}
