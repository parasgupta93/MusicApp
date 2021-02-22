package com.paras.musicapp.data;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.paras.musicapp.data.pojo.album.Album;
import com.paras.musicapp.data.pojo.album.Root;
import com.paras.musicapp.data.pojo.alubumdetail.AlbumDetail;
import com.paras.musicapp.data.pojo.alubumdetail.AlbumInfo;
import com.paras.musicapp.data.pojo.artist.AllArtists;
import com.paras.musicapp.data.pojo.artist.Artist;
import com.paras.musicapp.data.pojo.main.GenereDetail;
import com.paras.musicapp.data.pojo.main.Genre;
import com.paras.musicapp.data.pojo.main.Respons;
import com.paras.musicapp.data.pojo.track.Track;
import com.paras.musicapp.data.pojo.track.TrackRoot;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MusicRepository {

    final ApiService apiService;
    private final MutableLiveData<List<Genre>> genreList = new MutableLiveData<>();
    private final MutableLiveData<String> genreDetail = new MutableLiveData<>();
    private final MutableLiveData<List<Album>> albumArtistList = new MutableLiveData<>();
    private final MutableLiveData<List<Artist>> artistList = new MutableLiveData<>();
    private final MutableLiveData<List<Track>> trackList = new MutableLiveData<>();
    private final MutableLiveData<AlbumInfo> albumInfo = new MutableLiveData<>();


    @Inject
    public MusicRepository(ApiService service){this.apiService =service;}

    public void getAllGenre(){
         apiService.getGenres(Constants.TOP_GENRE,Constants.API_KEY,Constants.DATA_TYPE).enqueue(new Callback<Respons>() {

             @Override
             public void onResponse(Call<Respons> call, Response<Respons> response) {

                 if(response.isSuccessful() && response.body()!=null){
                         genreList.postValue(response.body().getTopGenres().getGenres());
                 }

             }

             @Override
             public void onFailure(Call<Respons> call, Throwable t) {
                 Log.d("Paras","onFailure"+Thread.currentThread().getName());
             }
         });


    }

    public  void  getGenreDetail(String genre){
        apiService.getGenreInfo(Constants.TAG_GETINFO,genre,Constants.API_KEY,Constants.DATA_TYPE).enqueue(new Callback<GenereDetail>() {
            @Override
            public void onResponse(Call<GenereDetail> call, Response<GenereDetail> response) {
                if(response.isSuccessful() && response.body()!=null){
                    genreDetail.postValue(response.body().getTag().getWiki().getSummary());
                }
            }

            @Override
            public void onFailure(Call<GenereDetail> call, Throwable t) {

            }
        });

    }

    public void getAbumDetail(String genre){
        apiService.getAlbumsDetail(Constants.TOP_ALBUM,genre,Constants.API_KEY,Constants.DATA_TYPE).enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                Log.d("Paras","getAlbumDetail"+response.isSuccessful()+"respnse body"+response.body());
                if(response.isSuccessful() && response.body()!=null){
                    Log.d("Paras","getAlbumDetails.........................................................");
                    albumArtistList.postValue(response.body().getAlbums().getAlbumList());
                }
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });

    }

    public void getArtistDetail(String genre){
        apiService.getArtistsDetail(Constants.TOP_ARTIST,genre,Constants.API_KEY,Constants.DATA_TYPE).enqueue(new Callback<AllArtists>() {
            @Override
            public void onResponse(Call<AllArtists> call, Response<AllArtists> response) {
                if(response.isSuccessful() && response.body()!=null){
                    Log.d("Paras","getArtistDetails.........................................................");
                    artistList.postValue(response.body().getTopArtists().getArtistList());
                }
            }

            @Override
            public void onFailure(Call<AllArtists> call, Throwable t) {

            }
        });

    }

    public void getTracksDetail(String genre){
        apiService.getTracksDetail(Constants.TOP_TRACK,genre,Constants.API_KEY,Constants.DATA_TYPE).enqueue(new Callback<TrackRoot>() {
            @Override
            public void onResponse(Call<TrackRoot> call, Response<TrackRoot> response) {
                if(response.isSuccessful() && response.body()!=null){
                    Log.d("Paras","getTrackDetails.........................................................");
                    trackList.postValue(response.body().getTopTracks().getTrackList());
                }
            }

            @Override
            public void onFailure(Call<TrackRoot> call, Throwable t) {

            }
        });

    }

    public void getAlbumInfo(String artist,String album){
        apiService.getAlbumInfo(Constants.ALBUM_INFO,Constants.API_KEY,artist,album,Constants.DATA_TYPE).enqueue(new Callback<AlbumDetail>() {
            @Override
            public void onResponse(Call<AlbumDetail> call, Response<AlbumDetail> response) {
                if(response.isSuccessful() && response.body()!=null){
                    Log.d("Paras","getAlbumInfo.........................................................");
                    albumInfo.postValue(response.body().getAlbumInfo());
                }
            }

            @Override
            public void onFailure(Call<AlbumDetail> call, Throwable t) {

            }
        });

    }

    public MutableLiveData<List<Genre>> getGenereLiveData() {
        return genreList;
    }

    public MutableLiveData<String> getGenereDetailLiveData() {
        return genreDetail;
    }

    public MutableLiveData<List<Album>> getAlbumArtistLiveData() {
        return albumArtistList;
    }

    public MutableLiveData<List<Artist>> getArtistLiveData() {
        return artistList;
    }

    public MutableLiveData<List<Track>> getTrackLiveData() {
        return trackList;
    }

    public MutableLiveData<AlbumInfo> getAlbumInfoLiveData() {
        return albumInfo;
    }

}
