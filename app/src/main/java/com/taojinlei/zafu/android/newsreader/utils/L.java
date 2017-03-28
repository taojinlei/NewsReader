package com.taojinlei.zafu.android.newsreader.utils;

import android.util.Log;

/**
 * 项目名:   NewsReader
 * 包名:     com.taojinlei.zafu.android.newsreader.utils
 * 文件名:   L
 * 创建者:   taojinlei
 * 创建时间:  2017/3/26下午1:21
 * 描述:     log类
 */
public class L {
    //开关
    public static final boolean DEBUG = true;

    //TAG
    public static final String TAG = "NewsReader";

    //五个等级
    public static void d(String text) {
        if (DEBUG) {
            Log.d(TAG, text);
        }
    }

    public static void i(String text) {
        if (DEBUG) {
            Log.i(TAG, text);
        }
    }

    public static void w(String text) {
        if (DEBUG) {
            Log.w(TAG, text);
        }
    }

    public static void e(String text) {
        if (DEBUG) {
            Log.e(TAG, text);
        }
    }
}
