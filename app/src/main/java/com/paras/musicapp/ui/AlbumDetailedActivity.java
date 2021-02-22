package com.paras.musicapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.button.MaterialButton;
import com.paras.musicapp.R;
import com.paras.musicapp.data.pojo.alubumdetail.AlbumTag;
import com.paras.musicapp.model.AlbumDetailViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AlbumDetailedActivity extends AppCompatActivity {

    String albumCover;
    String albumName;
    String artistName;

    TextView albumInfo;
    ImageView expandedImage;

    LinearLayout tagsLayout;
    AlbumDetailViewModel albumDetailViewModel;

    ArrayList<String> genreList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detailed);
        initViews();
        setObserver();
        albumDetailViewModel.fetchAlbumInfo(artistName,albumName);
    }

    private void initViews(){
        albumName = getIntent().getStringExtra("ALBUM_NAME");
        albumCover = getIntent().getStringExtra("ALBUM_COVER");
        artistName = getIntent().getStringExtra("ARTIST_NAME");
        tagsLayout = findViewById(R.id.tags_layout);
        expandedImage = findViewById(R.id.expandedImage);
        albumInfo = findViewById(R.id.item_info);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(albumName);
        Glide.with(this)
                .load(albumCover)
                .into(expandedImage);
        albumDetailViewModel = new ViewModelProvider(this).get(AlbumDetailViewModel.class);

    }

    private void setObserver(){
        albumDetailViewModel.getAlbumInfoLiveData().observe(this,albumInfo1 ->{
            albumInfo.setText(albumInfo1.getAlbumWiki().getContent());
            for (AlbumTag albumTag : albumInfo1.getTags().getAlbumTagArrayList()) {
                genreList.add(albumTag.getName());
            }
            buildGenreTag(genreList);
        } );
    }
    void buildGenreTag(ArrayList<String> genreList) {
        tagsLayout.removeAllViews();
        for (String genre : genreList) {
            MaterialButton materialButton = new MaterialButton(AlbumDetailedActivity.this, null, R.attr.chipStyle);
            materialButton.setText(genre.substring(0,1).toUpperCase()+genre.substring(1));
            materialButton.setBackgroundColor(getResources().getColor(R.color.grey));
            materialButton.setTextColor(getResources().getColor(R.color.colorAccent));
            materialButton.setCornerRadius(20);
            materialButton.setPadding(16, 18,16,18);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(16, 16, 16, 8);
            materialButton.setLayoutParams(params);
            tagsLayout.addView(materialButton);
            materialButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(AlbumDetailedActivity.this, GenreActivity.class);
                    i.putExtra("GENRE_NAME", materialButton.getText());
                    startActivity(i);
                    finish();
                }
            });
        }
    }
}