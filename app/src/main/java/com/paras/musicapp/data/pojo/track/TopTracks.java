package com.paras.musicapp.data.pojo.track;

import com.google.gson.annotations.SerializedName;
import com.paras.musicapp.data.pojo.common.TagAttr;

import java.util.ArrayList;

public class TopTracks {
    private ArrayList<Track> track;

    @SerializedName("@attr")
    private TagAttr tagAttr;

    public ArrayList<Track> getTrackList() {
        return track;
    }

    public TagAttr getTagAttr() {
        return tagAttr;
    }
}
