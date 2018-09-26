package com.khum.lib.net.dagger;

import com.khum.lib.global.dagger.ApplicationScope;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/10
 *     desc   : api组件
 * </pre>
 */
@ApplicationScope
@Component(modules = BaseApiModule.class)
public interface BaseApiComponent {
    OkHttpClient okHttpClientBean();
}
