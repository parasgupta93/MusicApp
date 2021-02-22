package com.paras.musicapp.data.pojo.main;

import com.google.gson.annotations.SerializedName;

public class Respons {

    @SerializedName("toptags")
    private TopGenres topGenres;

    public TopGenres getTopGenres() {
        return topGenres;
    }
}
