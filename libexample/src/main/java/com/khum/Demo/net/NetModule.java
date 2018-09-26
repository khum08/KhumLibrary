package com.khum.Demo.net;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.khum.lib.net.proxy.ApiServiceHandler;
import com.khum.lib.net.proxy.ApiServiceProxy;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/9
 *     desc   : 提供apiService的实例
 * </pre>
 */
@Module
public class NetModule {

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient okHttpClient){
        return okHttpClient;
    }

    @Provides
    @Singleton
    public Retrofit retrofitBean(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("http://47.89.191.130:8081/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    protected ApiService apiProxyBean(Retrofit retrofit,Context context) {
        ApiServiceProxy proxy = new ApiServiceProxy(retrofit, new ApiServiceHandler(), context);
        return proxy.getProxyInstance(ApiService.class);
    }
}

