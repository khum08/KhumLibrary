package com.khum.lib.global;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

import com.khum.lib.global.dagger.ContextComponent;
import com.khum.lib.global.dagger.ContextModule;
import com.khum.lib.global.dagger.DaggerContextComponent;
import com.khum.lib.utils.DeviceUtil;


/**
 * <pre>
 *     author : khum
 *     time   : 2018/4/26
 *     desc   : 维护设备信息
 * </pre>
 */
public class BaseApplication extends Application {

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
    public static ContextComponent mContextComponent;

    //此方法在onCreate()前调用
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        getDisplayMetrics(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initAppInfo();
        mContextComponent = DaggerContextComponent.builder().contextModule(new ContextModule(this)).build();
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

}
