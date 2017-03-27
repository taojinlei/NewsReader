package com.taojinlei.zafu.android.newsreader.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.taojinlei.zafu.android.newsreader.R;
import com.taojinlei.zafu.android.newsreader.adapter.NewsAdapter;
import com.taojinlei.zafu.android.newsreader.entity.NewsData;
import com.taojinlei.zafu.android.newsreader.ui.WebViewActivity;
import com.taojinlei.zafu.android.newsreader.utils.L;
import com.taojinlei.zafu.android.newsreader.utils.StaticClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名:   NewsReader
 * 包名:     com.taojinlei.zafu.android.newsreader.fragment
 * 文件名:   GuoJiFragment
 * 创建者:   taojinlei
 * 创建时间:  2017/3/26上午11:32
 * 描述:     国际
 */
public class GuoJiFragment extends Fragment {
    private ListView mListView;
    private List<NewsData> mList=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guoji, null);

        findView(view);
        return view;
    }

    private void findView(View view) {

        mListView = (ListView) view.findViewById(R.id.guoji_list_view);

        String url = "http://v.juhe.cn/toutiao/index?type=guoji&key=" + StaticClass.NEWS_KEY;
        RxVolley.get(url, new HttpCallback() {
            @Override
            public void onSuccess(String t) {
                L.i(t);
                parsingJson(t);
            }
        });

        //点击事件
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("title", "国际");
                intent.putExtra("url", mList.get(position).getTopUrl());
                startActivity(intent);

            }
        });

    }

    private void parsingJson(String t) {
        try {
            JSONObject jsonObject = new JSONObject(t);
            JSONObject jsonResult = jsonObject.getJSONObject("result");
            JSONArray jsonArray = jsonResult.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject json = (JSONObject) jsonArray.get(i);
                NewsData data = new NewsData();
                data.setTitle(json.getString("title"));
                data.setSource(json.getString("author_name"));
                data.setImgUrl(json.getString("thumbnail_pic_s"));
                data.setTopUrl(json.getString("url"));
                data.setTime(json.getString("date"));
                mList.add(data);
            }
            NewsAdapter adapter = new NewsAdapter(getActivity(), mList);
            mListView.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
