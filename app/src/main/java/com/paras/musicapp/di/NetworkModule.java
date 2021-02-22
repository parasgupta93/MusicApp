package com.paras.musicapp.di;
import android.util.Log;

import com.paras.musicapp.BaseApplication;
import com.paras.musicapp.data.ApiService;
import com.paras.musicapp.util.Utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(ApplicationComponent.class)
public class NetworkModule {
    static final String baseUrl = "https://ws.audioscrobbler.com/";

    public NetworkModule() {
    }

    @Provides
    @Singleton
    public static ApiService provideApi(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .callbackExecutor(Executors.newSingleThreadExecutor()).client(okHttpClient)
                .build().create(ApiService.class);
    }

    @Provides
    @Singleton
    public static OkHttpClient provideClient(Interceptor interceptor) {
/*
         return new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();
*/
        Cache cache = new Cache(new File(BaseApplication.getContext().getCacheDir(), "http-cache"), 10 * 1024 * 1024);
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    public static Interceptor provideInterceptor(){
        return new Interceptor() {
            @Override
            public Response intercept (Chain chain) throws IOException {
                Response response = chain.proceed( chain.request() );
                if(Utils.isNetworkAvailable()){
                    CacheControl cacheControl = new CacheControl.Builder()
                            .maxAge( 2, TimeUnit.MINUTES )
                            .build();

                    return response.newBuilder()
                            .header("Cache-Control", cacheControl.toString() )
                            .build();
                }
                else{
                    Log.d("Paras","Returning old");
                    return response;
                }
            }
        };

    }
}
