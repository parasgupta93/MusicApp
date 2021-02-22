package com.paras.musicapp.data.pojo.common;

import com.google.gson.annotations.SerializedName;

public class ImageDetail {
    @SerializedName("#text")
    private String text;

    @SerializedName("size")
    private String size;

    public String getText() {
        return text;
    }

    public String getSize() {
        return size;
    }
}
