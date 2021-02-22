package com.paras.musicapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.paras.musicapp.R;
import com.paras.musicapp.data.pojo.main.Genre;
import com.paras.musicapp.databinding.ActivityMusicBinding;
import com.paras.musicapp.model.MusicViewModel;
import com.paras.musicapp.ui.adapter.GenereAdapter;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MusicActivity extends AppCompatActivity {

    MusicViewModel musicViewModel;
    ActivityMusicBinding musicBinding;
    ArrayList<String> genreList = new ArrayList<>();
    GenereAdapter mGenereAdapter;
    public boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        musicViewModel = new ViewModelProvider(this).get(MusicViewModel.class);
        musicBinding = DataBindingUtil.setContentView(this, R.layout.activity_music);
        musicBinding.setActivity(this);
        init();
        initAdapter();
        setContentView(musicBinding.getRoot());
    }

    private void initAdapter() {
        mGenereAdapter = new GenereAdapter(this);
        musicBinding.recyleViewGenere.setLayoutManager(new GridLayoutManager(this, 3));
    }

    private void init() {
        musicViewModel.genreListLiveData.observe(this, genres -> {
            Log.d("Paras", "AAgya");
            for (Genre genre : genres) {
                genreList.add(genre.getName());
            }
            musicBinding.recyleViewGenere.setAdapter(mGenereAdapter);
            mGenereAdapter.setData(genreList);
        });
        musicViewModel.getAllGenere();
    }

    public void expandList() {
        if (!isClicked) {
            mGenereAdapter.setCount(genreList.size());
            musicBinding.arrowButton.setImageDrawable(getResources().getDrawable(R.drawable.arrow_down));
        } else {
            mGenereAdapter.setCount(9);
            musicBinding.arrowButton.setImageDrawable(getResources().getDrawable(R.drawable.arrow_up));

        }
        isClicked = !isClicked;
    }

}

