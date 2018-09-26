package com.khum.Demo.net;

import com.khum.lib.global.dagger.ContextComponent;
import com.khum.lib.net.dagger.BaseApiComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/9
 *     desc   :
 * </pre>
 */
@Singleton
@Component(dependencies = {BaseApiComponent.class, ContextComponent.class},
        modules = NetModule.class)
public interface NetComponent {
    ApiService provideApiService();
}
