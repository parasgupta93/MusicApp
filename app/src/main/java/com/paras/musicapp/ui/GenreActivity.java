package com.paras.musicapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.paras.musicapp.R;
import com.paras.musicapp.ui.adapter.CustomAdapter;
import com.paras.musicapp.model.GenreViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class GenreActivity extends AppCompatActivity {

    GenreViewModel genreViewModel;
    private TextView genreInfo;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Paras","Activity onCreate");
        genreViewModel = new ViewModelProvider(this).get(GenreViewModel.class);
        setContentView(R.layout.activity_genre);
        genreInfo = findViewById(R.id.genre_info);
        tabLayout= findViewById(R.id.htab_tabs);
        viewPager= findViewById(R.id.htab_viewpager);
        String genreName = getIntent().getStringExtra("GENRE_NAME");
        if(getSupportActionBar() != null)
        {
            assert genreName != null;
            getSupportActionBar().setTitle(genreName.substring(0,1).toUpperCase()+genreName.substring(1));
            getSupportActionBar().setElevation(0);
        }
        observeData();
        setAdapterUI();
        genreViewModel.fetchGenreDetail(genreName);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Paras","Activity onResume");
    }

    private void setAdapterUI(){
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.albums)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.artists)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tracks)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        adapter = new CustomAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), getIntent().getStringExtra("GENRE_NAME"));
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    private void observeData(){
        genreViewModel.genereDetailLiveData().observe(this,details->{
            Log.d("Paras","GenreActivityobservedata");
            genreInfo.setText(details);
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Paras","Activity onpause");
    }

}