package com.paras.musicapp.model;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.paras.musicapp.data.MusicRepository;
import com.paras.musicapp.data.pojo.main.Genre;

import java.util.List;

public class MusicViewModel extends ViewModel {

    MusicRepository musicRepository;
    public MutableLiveData<List<Genre>> genreListLiveData ;
    @ViewModelInject
    public  MusicViewModel(MusicRepository musicRepository){
        this.musicRepository =musicRepository;
        genreListLiveData =musicRepository.getGenereLiveData();
    }

    public void getAllGenere(){
        musicRepository.getAllGenre();
    }

    /*public LiveData<List<String>> transformList = Transformations.map(genreListLiveData,newdata->convertToString(newdata));

    List<String> convertToString(List<Genre> newdata){
        List<String> list = new ArrayList<>();
        for(Genre genre:newdata){
            list.add(genre.getName());
        }
        return list;
    }*/
}
