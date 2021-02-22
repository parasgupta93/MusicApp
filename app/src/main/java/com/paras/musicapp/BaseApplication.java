package com.paras.musicapp;

import android.app.Application;
import android.content.Context;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class BaseApplication extends Application {
    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance =this;
    }

    public static Context getContext(){
        return instance.getApplicationContext();
    }
}
