package com.khum.lib.net.proxy;

import android.content.Context;

import java.lang.reflect.Proxy;

import retrofit2.Retrofit;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/10
 *     desc   : 动态代理生成代理对象
 * </pre>
 */
public class ApiServiceProxy {

    private Retrofit mRetrofit;
    private ApiServiceHandler mApiServiceHandler;
    private Context mContext;

    public ApiServiceProxy(Retrofit retrofit,ApiServiceHandler apiServiceHandler,Context context) {
        this.mRetrofit = retrofit;
        this.mApiServiceHandler = apiServiceHandler;
        this.mContext = context;
    }

    public <T> T getProxyInstance(Class<T> tClass){
        T t = mRetrofit.create(tClass);
        mApiServiceHandler.setInvokeObject(t,mContext);
        return (T)Proxy.newProxyInstance(tClass.getClassLoader(),
                new Class<?>[]{tClass}, mApiServiceHandler);
    }



}
