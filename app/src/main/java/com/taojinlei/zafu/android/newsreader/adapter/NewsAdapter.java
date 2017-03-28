package com.taojinlei.zafu.android.newsreader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.taojinlei.zafu.android.newsreader.R;
import com.taojinlei.zafu.android.newsreader.entity.NewsData;
import com.taojinlei.zafu.android.newsreader.utils.PicassoUtils;

import java.util.List;

/**
 * 项目名:   NewsReader
 * 包名:     com.taojinlei.zafu.android.newsreader.adapter
 * 文件名:   NewsAdapter
 * 创建者:   taojinlei
 * 创建时间:  2017/3/27下午3:35
 * 描述:     newsadapter
 */
public class NewsAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<NewsData> mList;
    private NewsData mData;

    public NewsAdapter(Context context, List<NewsData> list) {
        mContext = context;
        mList = list;

        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.news_item, null);
            viewHolder.iv_img = (ImageView) convertView.findViewById(R.id.iv_img);
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.tv_source = (TextView) convertView.findViewById(R.id.tv_source);
            viewHolder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        mData = mList.get(position);
        viewHolder.tv_title.setText(mData.getTitle());
        viewHolder.tv_source.setText(mData.getSource());
        viewHolder.tv_time.setText(mData.getTime());

        //加载图片
        PicassoUtils.loadImageViewSize(mContext, mData.getImgUrl(), 400, 300, viewHolder.iv_img);

        return convertView;
    }


    class ViewHolder {
        private ImageView iv_img;
        private TextView tv_title;
        private TextView tv_source;
        private TextView tv_time;
    }
}

