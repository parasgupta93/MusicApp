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
import com.paras.musicapp.data.pojo.album.Album;
import com.paras.musicapp.ui.adapter.AlbumAdapter;
import com.paras.musicapp.model.GenreViewModel;

import java.util.List;

public class AlbumFragment extends Fragment {


    private AlbumAdapter adapter;
    GenreViewModel genreViewModel;
    private RecyclerView recyclerView;

    public AlbumFragment() {
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
        genreViewModel = new ViewModelProvider(requireActivity()).get(GenreViewModel.class);
        return inflater.inflate(R.layout.fragment_album, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new AlbumAdapter(getContext());
        recyclerView = (view).findViewById(R.id.recyleView);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(adapter);
        setObserver();
        genreViewModel.fetchAlbumArtistList(getActivity().getIntent().getStringExtra("GENRE_NAME"));
    }

    private void setObserver(){
          genreViewModel.getAlbumLiveData().observe(AlbumFragment.this.requireActivity(), new Observer<List<Album>>() {
              @Override
              public void onChanged(List<Album> albumList) {
                  Log.d("Paras","AlbumFragment..........................................................................");
                  adapter.setData(albumList);
              }
          });
        /*genreViewModel.albumArtistLiveData.observeForever(alumlist->{
            Log.d("Paras","AlbumFragment..........................................................................");
            adapter.setData(alumlist);
        });*/
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}