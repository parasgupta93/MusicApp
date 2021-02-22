package com.paras.musicapp.data.pojo.track;

import com.google.gson.annotations.SerializedName;
import com.paras.musicapp.data.pojo.common.ImageDetail;

import java.util.ArrayList;

public class Track {
    private String name;
    private String url;

    @SerializedName("image")
    private ArrayList<ImageDetail> image;

    private ArtistInfo artist;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public ArtistInfo getArtistInfo() {
        return artist;
    }

    public ArrayList<ImageDetail> getImage() {
        return image;
    }

}
