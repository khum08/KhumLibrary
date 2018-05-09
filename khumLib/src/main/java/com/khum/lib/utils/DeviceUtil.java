package com.khum.lib.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/4/26
 *     desc   : 设备相关的工具类
 * </pre>
 */
public class DeviceUtil {

    /**
     * 获取设备的分辨率
     * @param context
     */
    public static DisplayMetrics get(Context context){
        return context.getResources().getDisplayMetrics();
    }

}
