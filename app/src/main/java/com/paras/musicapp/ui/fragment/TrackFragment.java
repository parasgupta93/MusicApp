package com.paras.musicapp.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.paras.musicapp.R;
import com.paras.musicapp.data.pojo.artist.Artist;
import com.paras.musicapp.data.pojo.track.Track;
import com.paras.musicapp.model.GenreViewModel;
import com.paras.musicapp.ui.adapter.ArtistAdapter;
import com.paras.musicapp.ui.adapter.TrackAdapter;

import java.util.List;


public class TrackFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private TrackAdapter mTrackAdapter;
    private GenreViewModel mGenreViewModel;

    public TrackFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mGenreViewModel = new ViewModelProvider(requireActivity()).get(GenreViewModel.class);

        return inflater.inflate(R.layout.fragment_album, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTrackAdapter = new TrackAdapter(getContext());
        mRecyclerView = (view).findViewById(R.id.recyleView);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mRecyclerView.setAdapter(mTrackAdapter);
        setObserver();
        mGenreViewModel.fetchTrackList(getActivity().getIntent().getStringExtra("GENRE_NAME"));
    }

    private void setObserver() {
        mGenreViewModel.gettrackLiveData().observe(requireActivity(), new Observer<List<Track>>() {
            @Override
            public void onChanged(List<Track> artistList) {
                Log.d("Paras", "ArtistFragment..........................................................................");
                mTrackAdapter.setData(artistList);
            }
        });
    }
}