package com.paras.musicapp.data.pojo.track;

import com.google.gson.annotations.SerializedName;

public class TrackRoot {

    @SerializedName("tracks")
    private TopTracks topTracks;

    public TopTracks getTopTracks() {
        return topTracks;
    }

}
