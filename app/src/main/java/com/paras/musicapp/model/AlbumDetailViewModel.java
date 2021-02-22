package com.paras.musicapp.model;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.paras.musicapp.data.MusicRepository;
import com.paras.musicapp.data.pojo.alubumdetail.AlbumInfo;

public class AlbumDetailViewModel extends ViewModel {

    MusicRepository musicRepository;

    @ViewModelInject
    public  AlbumDetailViewModel(MusicRepository musicRepository){
        this.musicRepository = musicRepository;
    }

    public void fetchAlbumInfo(String artist,String album){
        musicRepository.getAlbumInfo(artist,album);
    }

    public MutableLiveData<AlbumInfo> getAlbumInfoLiveData(){
        return musicRepository.getAlbumInfoLiveData();
    }


}
