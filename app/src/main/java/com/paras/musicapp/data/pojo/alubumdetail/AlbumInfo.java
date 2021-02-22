package com.paras.musicapp.data.pojo.alubumdetail;

import com.google.gson.annotations.SerializedName;
import com.paras.musicapp.data.pojo.common.ImageDetail;
import com.paras.musicapp.data.pojo.main.Wiki;

import java.util.ArrayList;

public class AlbumInfo {
    private String name;
    private String artist;
    private String mbid;
    private String url;

    @SerializedName("image")
    private ArrayList<ImageDetail> imageInfo;

    private AlbumTags tags;

    @SerializedName("wiki")
    private Wiki albumWiki;

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getMbid() {
        return mbid;
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<ImageDetail> getImageInfo() {
        return imageInfo;
    }


    public AlbumTags getTags() {
        return tags;
    }

    public Wiki getAlbumWiki() {
        return albumWiki;
    }
}
