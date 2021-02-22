package com.paras.musicapp.util;

import android.content.Context;
import android.net.ConnectivityManager;

import com.paras.musicapp.BaseApplication;

public class Utils {
    public static boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager = (ConnectivityManager) BaseApplication.getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo() != null
                && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
