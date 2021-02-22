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
import com.paras.musicapp.data.pojo.artist.Artist;
import java.util.ArrayList;
import java.util.List;

/*
 ** This Class is Used to fetch the data from the POJO Location and bind them to the views.
 **/
public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ViewHolder> {

    private List<Artist> list = new ArrayList<Artist>();
    private Context mContext;

    public ArtistAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Artist> artistList){
        list.clear();
        list.addAll(artistList);
        notifyDataSetChanged();
    }
    /*
     ** inflating the cardView.
     **/
    @Override
    public ArtistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.common_item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArtistAdapter.ViewHolder holder, int position) {
        Artist artist = list.get(position);
        holder.artistName.setText(String.valueOf(artist.getName()));
        String cover = artist.getImage().get(0).getText();
        String artistName = artist.getName();

        Glide.with(mContext)
                .load(cover)
                .thumbnail(0.1f)
                .centerCrop()
                .error(R.drawable.not_found)
                .into(holder.artistCover);
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
        TextView artistName;
        CardView cardView;
        ImageView artistCover;

        public ViewHolder(View view) {
            super(view);
            cardView = itemView.findViewById(R.id.card_view);
            cardView = itemView.findViewById(R.id.card_view);
            artistCover = itemView.findViewById(R.id.cover);
            artistName = itemView.findViewById(R.id.name);
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
