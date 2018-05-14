package com.khum.lib.net.dagger;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.khum.lib.global.DefaultApplication;
import com.khum.lib.global.dagger.ContextModule;
import com.khum.lib.net.dynamicproxy.ApiServiceHandler;
import com.khum.lib.net.dynamicproxy.ApiServiceProxy;
import com.khum.lib.net.interceptor.LogInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/10
 *     desc   : 为app提供网络层api的module
 *              T为网络层ApiService的抽象
 * </pre>
 */
@Module
public abstract class AppApiModule<T> extends ContextModule {

    private static final int DEFAULT_TIME_OUT = 10;

    public AppApiModule(Context context) {
        super(context);
    }

    @Provides
    @Singleton
    public T provideApiService(){
        ApiServiceProxy apiServiceProxy = new ApiServiceProxy(provideRetrofit(), new ApiServiceHandler(), mContext);
        return apiServiceProxy.getProxyInstance(setApiService());
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(setBaseUrl())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(provideOkHttpClient())
                .build();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(){
        Cache cache = new Cache(new File(DefaultApplication.mContext.getCacheDir(), "HttpCache"),
                1024 * 1024 * 100);
        return new OkHttpClient.Builder()
                .cache(cache)
                .retryOnConnectionFailure(true)
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS)
                .addInterceptor(setRequestInterceptor())
                .addInterceptor(new LogInterceptor())
                .build();
    }

    //设置apiservice的baseUrl
    protected abstract String setBaseUrl();
    //设置请求拦截器
    protected abstract Interceptor setRequestInterceptor();
    //设置ApiService
    protected abstract Class<T> setApiService();

}
