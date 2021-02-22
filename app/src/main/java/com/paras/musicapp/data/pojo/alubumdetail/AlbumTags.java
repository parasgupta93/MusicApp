package com.paras.musicapp.data.pojo.alubumdetail;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AlbumTags {

    @SerializedName("tag")
    private ArrayList<AlbumTag> albumTagArrayList;

    public ArrayList<AlbumTag> getAlbumTagArrayList() {
        return albumTagArrayList;
    }
}
