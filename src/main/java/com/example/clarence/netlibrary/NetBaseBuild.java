package com.example.clarence.netlibrary;

import android.content.Context;

/**
 * Created by clarence on 2018/3/23.
 */

public abstract class NetBaseBuild {
    private Context context;

    public Context getContext() {
        return context;
    }

    public NetBaseBuild(Context context) {
        this.context = context;
    }

    public abstract INet build();
}
