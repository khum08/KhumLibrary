package com.khum.lib.global.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/9
 *     desc   :
 * </pre>
 */
@Module
public class ContextModule {

    public Context mContext;
    public ContextModule(Context context){
        this.mContext = context;
    }

    @Provides
    @ApplicationScope
    public Context provideContext(){
        return mContext;
    }

}
