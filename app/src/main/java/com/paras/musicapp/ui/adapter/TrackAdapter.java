package com.paras.musicapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.paras.musicapp.R;
import com.paras.musicapp.data.pojo.track.Track;

import java.util.ArrayList;
import java.util.List;

/*
 ** This Class is Used to fetch the data from the POJO Location and bind them to the views.
 **/
public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.ViewHolder> {

    private List<Track> list = new ArrayList<Track>();
    private Context mContext;

    public TrackAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Track> trackList){
        list.clear();
        list.addAll(trackList);
        notifyDataSetChanged();
    }
    /*
     ** inflating the cardView.
     **/
    @Override
    public TrackAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.common_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TrackAdapter.ViewHolder holder, int position) {
        Track track = list.get(position);
        String artistName = track.getArtistInfo().getName();
        holder.trackArtist.setText(artistName);
        holder.trackName.setText(String.valueOf(track.getName()));
        String cover = track.getImage().get(2).getText();

        Glide.with(mContext)
                .load(cover)
                .thumbnail(0.1f)
                .centerCrop()
                .error(R.drawable.not_found)
                .into(holder.trackCover);
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
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cardView;
        TextView trackName;
        TextView trackArtist;
        ImageView trackCover;

        public ViewHolder(View view) {
            super(view);
            cardView = itemView.findViewById(R.id.card_view);
            trackCover = itemView.findViewById(R.id.cover);
            trackName = itemView.findViewById(R.id.name);
            trackArtist = itemView.findViewById(R.id.artist_name);
        }

        @Override
        public void onClick(View v) {

            /*String description = locations.get(getAdapterPosition()).getDescription();
            String date = locations.get(getAdapterPosition()).getDate();
            String url = locations.get(getAdapterPosition()).getUrl();
            String rate = locations.get(getAdapterPosition()).getRate();
            String place = locations.get(getAdapterPosition()).getPlace();
            Intent intent = new Intent(mContext, LocationDetailedActivity.class);

            intent.putExtra(Constants.INTENT_DESCRIPTION, description);
            intent.putExtra(Constants.INTENT_DATE, date);
            intent.putExtra(Constants.INTENT_URL, url);
            intent.putExtra(Constants.INTENT_RATE, rate);
            intent.putExtra(Constants.INTENT_PLACE, place);

            mContext.startActivity(intent);*/

        }
    }
}
