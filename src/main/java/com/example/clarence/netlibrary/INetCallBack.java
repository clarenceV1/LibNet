package com.example.clarence.netlibrary;

import org.reactivestreams.Subscription;

public interface INetCallBack<T> {

    void respondResult(Subscription subscription, T t);

    void respondError(Throwable t);

}
