package com.paras.musicapp.data.pojo.artist;

import com.paras.musicapp.data.pojo.common.ImageDetail;

import java.util.ArrayList;

public class Artist {
    private String name;
    private String url;
    private ArrayList<ImageDetail> image;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<ImageDetail> getImage() {
        return image;
    }

}
