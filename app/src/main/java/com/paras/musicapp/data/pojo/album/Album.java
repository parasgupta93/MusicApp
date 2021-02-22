package com.paras.musicapp.data.pojo.album;


import com.google.gson.annotations.SerializedName;
import com.paras.musicapp.data.pojo.common.ImageDetail;

import java.util.ArrayList;

public class Album {
    private String name;
    private String mbid;
    private String url;
    private ArrayList<ImageDetail> image;

    @SerializedName("artist")
    private AlbumArtist albumArtist;

    public String getName() {
        return name;
    }

    public String getMbid() {
        return mbid;
    }

    public String getUrl() {
        return url;
    }

    public AlbumArtist getAlbumArtist() {
        return albumArtist;
    }

    public ArrayList<ImageDetail> getImage() {
        return image;
    }

}
