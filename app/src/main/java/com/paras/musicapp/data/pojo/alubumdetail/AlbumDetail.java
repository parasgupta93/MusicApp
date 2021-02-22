package com.paras.musicapp.data.pojo.alubumdetail;

import com.google.gson.annotations.SerializedName;

public class AlbumDetail {

    @SerializedName("album")
    private AlbumInfo albumInfo;

    public AlbumInfo getAlbumInfo() {
        return albumInfo;
    }
}
