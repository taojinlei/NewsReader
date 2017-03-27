package com.taojinlei.zafu.android.newsreader;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.taojinlei.zafu.android.newsreader.fragment.CaiJingFragment;
import com.taojinlei.zafu.android.newsreader.fragment.GuoJiFragment;
import com.taojinlei.zafu.android.newsreader.fragment.GuoNeiFragment;
import com.taojinlei.zafu.android.newsreader.fragment.JunShiFragment;
import com.taojinlei.zafu.android.newsreader.fragment.KeJiFragment;
import com.taojinlei.zafu.android.newsreader.fragment.SheHuiFragment;
import com.taojinlei.zafu.android.newsreader.fragment.ShiShangFragment;
import com.taojinlei.zafu.android.newsreader.fragment.TiYuFragment;
import com.taojinlei.zafu.android.newsreader.fragment.TopFragment;
import com.taojinlei.zafu.android.newsreader.fragment.YuLeFragment;
import com.taojinlei.zafu.android.newsreader.ui.SettingActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private TextView tvHint;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FloatingActionButton fab_setting;

    private List<String> mTitle;
    private List<Fragment> mFragmentList;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initData();
        initView();

        tvHint = (TextView) this.findViewById(R.id.tv_hint);
        Animation animation = new AlphaAnimation(0f, 1f);
        animation.setDuration(3000);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);
        tvHint.startAnimation(animation);
    }

    //初始化view
    private void initView() {
        fab_setting = (FloatingActionButton) findViewById(R.id.fab_setting);
        fab_setting.setOnClickListener(this);

        mTabLayout = (TabLayout) findViewById(R.id.mTabLayout);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);

        //预加载
        mViewPager.setOffscreenPageLimit(mFragmentList.size());
        //设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //选中的item
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            //返回item个数
            @Override
            public int getCount() {
                return mFragmentList.size();
            }

            //设置标题

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });

        //绑定
        mTabLayout.setupWithViewPager(mViewPager);

    }

    //初始化数组
    private void initData() {
        mTitle = new ArrayList<>();
        mTitle.add("头条");
        mTitle.add("社会");
        mTitle.add("国内");
        mTitle.add("国际");
        mTitle.add("娱乐");
        mTitle.add("体育");
        mTitle.add("军事");
        mTitle.add("科技");
        mTitle.add("财经");
        mTitle.add("时尚");

        mFragmentList = new ArrayList<>();
        mFragmentList.add(new TopFragment());
        mFragmentList.add(new SheHuiFragment());
        mFragmentList.add(new GuoNeiFragment());
        mFragmentList.add(new GuoJiFragment());
        mFragmentList.add(new YuLeFragment());
        mFragmentList.add(new TiYuFragment());
        mFragmentList.add(new JunShiFragment());
        mFragmentList.add(new KeJiFragment());
        mFragmentList.add(new CaiJingFragment());
        mFragmentList.add(new ShiShangFragment());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_setting:
                startActivity(new Intent(this, SettingActivity.class));
                break;
        }
    }
}
