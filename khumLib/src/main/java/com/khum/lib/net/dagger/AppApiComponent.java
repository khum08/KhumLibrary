package com.khum.lib.net.dagger;

import com.khum.lib.global.dagger.ContextComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/10
 *     desc   : api组件
 * </pre>
 */
@Singleton
@Component(dependencies = AppApiModule.class)
public interface AppApiComponent<T> extends ContextComponent {

    T provideApiService();
}
