package com.example.clarence.netlibrary;

import android.content.Context;

/**
 * Created by clarence on 2018/3/23.
 */

public class Net1Build extends NetBaseBuild {
    private String baseUrl;

    public Net1Build(Context context) {
        super(context);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public Net1Build baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public INet build(){
        return new Net1(this);
    }
}
