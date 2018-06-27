package com.example.clarence.netlibrary;

import java.util.Map;

import retrofit2.Retrofit;

/**
 * Created by clarence on 2018/3/22.
 */

public interface INet {
    Retrofit request();
    Retrofit request(Map<String, String> headerMap);
}
