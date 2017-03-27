package com.taojinlei.zafu.android.newsreader.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.taojinlei.zafu.android.newsreader.MainActivity;
import com.taojinlei.zafu.android.newsreader.R;
import com.taojinlei.zafu.android.newsreader.utils.ShareUtil;
import com.taojinlei.zafu.android.newsreader.utils.StaticClass;
import com.taojinlei.zafu.android.newsreader.utils.UtilTools;

/**
 * 项目名:   NewsReader
 * 包名:     com.taojinlei.zafu.android.newsreader.ui
 * 文件名:   SplashActivity
 * 创建者:   taojinlei
 * 创建时间:  2017/3/26下午2:05
 * 描述:     闪屏页
 */
public class SplashActivity extends AppCompatActivity {

    /**
     * 1.延时1000ms
     * 2.判断程序时候第一次运行
     * 3.自定义字体
     * 4.Activity全屏主题
     */

    private TextView tv_splash;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case StaticClass.HANDLER_SPLASH:
                    //2.判断程序时候第一次运行
                    if (isFirst()) {
                        startActivity(new Intent(SplashActivity.this, GuideActivity.class));
                        finish();
                    } else {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        finish();
                    }
                    break;
            }
        }
    };




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
    }

    private void initView() {
        //1.延时1000ms
        handler.sendEmptyMessageDelayed(StaticClass.HANDLER_SPLASH,1000);

        tv_splash = (TextView) findViewById(R.id.tv_splash);
        UtilTools.setFont(this, tv_splash);

    }

    //2.判断程序时候第一次运行
    private boolean isFirst() {
        boolean isFirst = ShareUtil.getBoolean(this, StaticClass.SHARE_IS_FIRST, true);
        if (isFirst) {
            ShareUtil.putBoolean(this, StaticClass.SHARE_IS_FIRST, false);
            //是第一次运行
            return true;
        } else {
            return false;
        }
    }


    //禁止返回键
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
