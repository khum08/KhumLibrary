package com.khum.lib.net.dagger;

import com.khum.lib.global.DefaultApplication;
import com.khum.lib.global.dagger.ApplicationScope;
import com.khum.lib.net.interceptor.LogInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/10
 *     desc   : 为app提供网络层api的module
 *              T为网络层ApiService的抽象
 * </pre>
 */
@Module
public class BaseApiModule {

    private static final int DEFAULT_TIME_OUT = 10;

    @Provides
    @ApplicationScope
    public OkHttpClient provideOkHttpClient(){
        Cache cache = new Cache(new File(DefaultApplication.mContext.getCacheDir(), "HttpCache"),
                1024 * 1024 * 100);
        return new OkHttpClient.Builder()
                .cache(cache)
                .retryOnConnectionFailure(true)
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIME_OUT,TimeUnit.SECONDS)
                .addInterceptor(new LogInterceptor())
                .build();
    }




}
