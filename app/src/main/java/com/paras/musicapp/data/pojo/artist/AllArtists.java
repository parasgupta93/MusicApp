package com.paras.musicapp.data.pojo.artist;

import com.google.gson.annotations.SerializedName;

public class AllArtists {

    @SerializedName("topartists")
    private TopArtists topArtists;

    public TopArtists getTopArtists() {
        return topArtists;
    }
}
