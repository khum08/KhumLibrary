package com.khum.lib.global;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

import com.khum.lib.global.dagger.ContextComponent;
import com.khum.lib.global.dagger.ContextModule;
import com.khum.lib.global.dagger.DaggerContextComponent;
import com.khum.lib.net.dagger.BaseApiModule;
import com.khum.lib.net.dagger.DaggerBaseApiComponent;
import com.khum.lib.utils.DeviceUtil;


/**
 * <pre>
 *     author : khum
 *     time   : 2018/4/26
 *     desc   : 维护设备信息
 *              子类应当重写:
 *                  initAppInfo()
 *                  setIsDebug()
 * </pre>
 */
public abstract class DefaultApplication extends Application {

    //手机的宽高
    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    public static float DENSITY;
    //app的ID和秘钥
    public static String appId;
    public static String appSecret;
    public static String appName;
    public static String appVersion;
    //用于提供全局的Context对象
    public static Context mContext;
    public static ContextComponent mContextComponent;
    public static boolean isDebug;

    //此方法在onCreate()前调用
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        getDisplayMetrics(base);
        mContext = getApplicationContext();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        DaggerContextComponent.builder().contextModule(new ContextModule(this)).build();
        DaggerBaseApiComponent.builder().baseApiModule(new BaseApiModule()).build();
        initApiComponent();
        initAppInfo();
        isDebug = setIsDebug();
    }

    //设备分辨率
    public void getDisplayMetrics(Context base) {
        DisplayMetrics displayMetrics = DeviceUtil.get(base);
        SCREEN_WIDTH = displayMetrics.widthPixels;
        SCREEN_HEIGHT = displayMetrics.heightPixels;
        DENSITY = displayMetrics.density;
    }

    //app相关的信息 在子类中需要重写
    protected void initAppInfo() {
        appId = "APPID";
        appSecret = "APPSECRET";
        appName = "APPNAME";
        appVersion = "APPVERSION";
    }

    //设置是否是Debug模式
    protected boolean setIsDebug(){
        return true;
    }

    protected abstract void initApiComponent();

}
