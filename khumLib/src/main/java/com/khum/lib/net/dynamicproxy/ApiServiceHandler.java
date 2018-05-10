package com.khum.lib.net.dynamicproxy;

import android.content.Context;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/10
 *     desc   :
 * </pre>
 */
public class ApiServiceHandler implements InvocationHandler {

    private Object mRetrofit;
    private Context mContext;

    public void setInvokeObject(Object retrofit, Context context){
        this.mRetrofit = retrofit;
        this.mContext = context;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
