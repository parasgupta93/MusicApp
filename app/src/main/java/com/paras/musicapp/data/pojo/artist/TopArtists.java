package com.paras.musicapp.data.pojo.artist;

import com.google.gson.annotations.SerializedName;
import com.paras.musicapp.data.pojo.common.TagAttr;

import java.util.List;

public class TopArtists {
    @SerializedName("artist")
    private List<Artist> artistList;

    @SerializedName("@attr")
    private TagAttr tagAttr;

    public List<Artist> getArtistList() {
        return artistList;
    }

    public TagAttr getTagAttr() {
        return tagAttr;
    }
}
