package com.paras.musicapp.data.pojo.album;

import com.google.gson.annotations.SerializedName;
import com.paras.musicapp.data.pojo.common.TagAttr;

import java.util.ArrayList;

public class Albums {
    @SerializedName("album")
    private ArrayList<Album> albumList;

    @SerializedName("@attr")
    private TagAttr tagAttr;

    public ArrayList<Album> getAlbumList() {
        return albumList;
    }

    public TagAttr getTagAttr() {
        return tagAttr;
    }
}
