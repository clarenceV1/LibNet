package com.example.clarence.netlibrary;

import retrofit2.Retrofit;

/**
 * 获取各种类型的网络请求入口
 * Created by clarence on 16/6/20.
 */
public class NetFactory implements INet {

    private INet net;

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
    public void init(NetBaseBuild baseBuild) {
        if (net != null) {
            return;
        }
        net = baseBuild.build();
    }

    @Override
    public Retrofit request() {
        if (net == null) {
            throw new NullPointerException("hei ！net == null,u need call com.cai.framework.manager.NetDock.initNet()");
        }
        return net.request();
    }
}
