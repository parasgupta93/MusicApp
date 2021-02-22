package com.paras.musicapp.data;

import com.paras.musicapp.data.pojo.album.Root;
import com.paras.musicapp.data.pojo.alubumdetail.AlbumDetail;
import com.paras.musicapp.data.pojo.artist.AllArtists;
import com.paras.musicapp.data.pojo.main.GenereDetail;
import com.paras.musicapp.data.pojo.main.Respons;
import com.paras.musicapp.data.pojo.main.TopGenres;
import com.paras.musicapp.data.pojo.track.TrackRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("2.0/")
    Call<Respons> getGenres(
            @Query("method") String allGenres,
            @Query("api_key") String apiKey,
            @Query("format") String json
    );

    @GET("2.0/")
    Call<GenereDetail> getGenreInfo(
            @Query("method") String genreInfo,
            @Query("tag") String genre,
            @Query("api_key") String apiKey,
            @Query("format") String json
    );

    @GET("2.0/")
    Call<Root> getAlbumsDetail(
            @Query("method") String allAlbums,
            @Query("tag") String genre,
            @Query("api_key") String apiKey,
            @Query("format") String json
    );

    @GET("2.0/")
    Call<AllArtists> getArtistsDetail(
            @Query("method") String allArtists,
            @Query("tag") String genre,
            @Query("api_key") String apiKey,
            @Query("format") String json
    );

    @GET("2.0/")
    Call<TrackRoot> getTracksDetail(
            @Query("method") String allTracks,
            @Query("tag") String genre,
            @Query("api_key") String apiKey,
            @Query("format") String json
    );

    @GET("2.0/")
    Call<AlbumDetail> getAlbumInfo(
            @Query("method") String albumInfo,
            @Query("api_key") String apiKey,
            @Query("artist") String artist,
            @Query("album") String album,
            @Query("format") String json
    );

}
