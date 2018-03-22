package com.example.clarence.netlibrary;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by clarence on 2018/3/21.
 */

public class NetHeadInterceptor implements Interceptor {
    Context context;

    public NetHeadInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .build());
    }
}
