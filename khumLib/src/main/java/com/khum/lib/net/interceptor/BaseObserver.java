package com.khum.lib.net.interceptor;

import com.khum.lib.net.model.NetWorkData;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/10
 *     desc   :
 * </pre>
 */
public abstract class BaseObserver<T> implements Observer<NetWorkData<T>> {

    @Override
    public void onSubscribe(Disposable d) {
        doSubscribe(d);
    }

    @Override
    public void onNext(NetWorkData<T> tNetWorkData) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    protected abstract void doSubscribe(Disposable d);
    protected abstract void doSuccess(int code, String message, T data);
    protected abstract void doError(Throwable throwable);

}
