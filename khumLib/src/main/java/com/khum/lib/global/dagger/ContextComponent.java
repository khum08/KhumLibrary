package com.khum.lib.global.dagger;

import android.content.Context;

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
@Component(dependencies = ContextModule.class)
public interface ContextComponent {
    Context provideContext();
}
