package com.khum.lib.utils;

import android.util.Log;

import com.khum.lib.global.DefaultApplication;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/10
 *     desc   : Log工具类
 * </pre>
 */
public class LogUtils {

    private static boolean isDebug = DefaultApplication.isDebug;

    public static void v(String tag, String msg) {
        if (isDebug) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (isDebug) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, msg);
        }
    }
}
