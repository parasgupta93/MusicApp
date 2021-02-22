package com.paras.musicapp.model;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.paras.musicapp.data.MusicRepository;
import com.paras.musicapp.data.pojo.album.Album;
import com.paras.musicapp.data.pojo.artist.Artist;
import com.paras.musicapp.data.pojo.track.Track;

import java.util.List;

public class GenreViewModel extends ViewModel {

    MusicRepository musicRepository;
  //  public MutableLiveData<String> genereDetailLiveData;

    @ViewModelInject
    public  GenreViewModel(MusicRepository musicRepository){
        this.musicRepository = musicRepository;
    }

    public void fetchGenreDetail(String genre){
        musicRepository.getGenreDetail(genre);
    }

    public void fetchAlbumArtistList(String genre){
        musicRepository.getAbumDetail(genre);
    }

    public void fetchArtistList(String genre){
        musicRepository.getArtistDetail(genre);
    }

    public void fetchTrackList(String genre){
        musicRepository.getTracksDetail(genre);
    }

    public MutableLiveData<String> genereDetailLiveData(){
        return musicRepository.getGenereDetailLiveData();
    }

    public MutableLiveData<List<Album>> getAlbumLiveData(){
        return musicRepository.getAlbumArtistLiveData();
    }

    public MutableLiveData<List<Artist>> getArtistLiveData(){
        return musicRepository.getArtistLiveData();
    }

    public MutableLiveData<List<Track>> gettrackLiveData(){
        return musicRepository.getTrackLiveData();
    }

}
