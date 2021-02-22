package com.paras.musicapp.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.paras.musicapp.ui.fragment.AlbumFragment;
import com.paras.musicapp.ui.fragment.ArtistFragment;
import com.paras.musicapp.ui.fragment.TrackFragment;

public class CustomAdapter extends FragmentPagerAdapter {

    int tabCount;
    String genreName;

    public CustomAdapter(FragmentManager fm, int tabCount, String genreName) {
        super(fm);
        this.tabCount = tabCount;
        this.genreName = genreName;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AlbumFragment albumsFragment = new AlbumFragment();
                return albumsFragment;
            case 1:
                ArtistFragment artistsFragment = new ArtistFragment();
                return artistsFragment;
            case 2:
                TrackFragment tracksFragment = new TrackFragment();
                return tracksFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
