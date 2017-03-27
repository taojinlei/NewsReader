package com.taojinlei.zafu.android.newsreader.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

import static com.taojinlei.zafu.android.newsreader.R.id.tv_splash;

/**
 * 项目名:   NewsReader
 * 包名:     com.taojinlei.zafu.android.newsreader.utils
 * 文件名:   UtilTools
 * 创建者:   taojinlei
 * 创建时间:  2017/3/25下午7:32
 * 描述:     TODO
 */
public class UtilTools {
    public static void setFont(Context context, TextView textView) {
        //设置字体
        Typeface fontType = Typeface.createFromAsset(context.getAssets(), "fonts/FONT.TTF");
        textView.setTypeface(fontType);
    }
}
