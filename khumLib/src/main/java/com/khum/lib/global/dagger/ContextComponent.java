package com.khum.lib.global.dagger;

import android.content.Context;

import dagger.Component;


/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/9
 *     desc   :
 * </pre>
 */
@ApplicationScope
@Component(modules = ContextModule.class)
public interface ContextComponent {
    Context provideContext(Context context);
}
