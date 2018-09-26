package com.khum.lib.net.proxy;

import android.content.Context;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/10
 *     desc   : 这是一个retrofit生成的接口代理类的代理
 *              ApiServiceHandler -> retrofit proxy -> ApiService接口
 * </pre>
 */
public class ApiServiceHandler implements InvocationHandler {

    private Object mRetrofit;
    private Context mContext;

    public void setInvokeObject(Object retrofit, Context context) {
        this.mRetrofit = retrofit;
        this.mContext = context;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return Observable.just("start")
                .map(new Function<String, Observable<?>>() {
                    @Override
                    public Observable<?> apply(String s) throws Exception {
                        return (Observable<?>) method.invoke(mRetrofit, args);
                    }
                })
                .retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                        //todo 此处处理失败重试
                        return null;
                    }
                });
    }
}
