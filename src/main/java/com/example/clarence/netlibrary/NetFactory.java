package com.example.clarence.netlibrary;

import android.content.Context;

import retrofit2.Retrofit;

/**
 * 获取各种类型的网络请求入口
 * Created by clarence on 16/6/20.
 */
public class NetFactory implements INet{

    private boolean isDebug = false;
    private INet net;
    private Context context;
    private String baseUrl;

    private static class SingletonHolder {
        private static final NetFactory instance = new NetFactory();
    }

    public static final NetFactory getInsatance() {
        return NetFactory.SingletonHolder.instance;
    }

    private NetFactory() {

    }

    /**
     * 初始化一次就够了
     */
    public void init(Context context, int type, boolean isDebug) {
        this.context = context;
        this.isDebug = isDebug;
        this.net = getNet(type);
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private INet getNet(int type) {
        INet iNet = null;
        switch (type) {
            case 1:
                iNet = new Net1(context, baseUrl);
                break;
            default:
                iNet = new Net1(context, baseUrl);
                break;
        }
        return iNet;
    }

    @Override
    public Retrofit request() {
        return net.request();
    }
}
