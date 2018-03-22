package com.example.clarence.netlibrary;

import android.content.Context;

import com.example.clarence.utillibrary.log.LogFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by clarence on 2018/3/22.
 */

public class Net1 implements INet {
    private Retrofit retrofit;

    public Net1(Context context, String baseUrl) {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogFactory.getInsatance().debug("logInterceptor", message);
            }
        });
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        File cacheFile = new File(context.getCacheDir(), "cache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 10); //100Mb

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(30000, TimeUnit.MILLISECONDS)
                .connectTimeout(30000, TimeUnit.MILLISECONDS)
                .addInterceptor(new NetHeadInterceptor(context))
                .addInterceptor(logInterceptor)
                .addNetworkInterceptor(new NetworkInterceptor(context))
                .cache(cache)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    @Override
    public Retrofit request() {
        return retrofit;
    }
}
