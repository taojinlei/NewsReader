package com.taojinlei.zafu.android.newsreader.entity;

/**
 * 项目名:   NewsReader
 * 包名:     com.taojinlei.zafu.android.newsreader.entity
 * 文件名:   NewsData
 * 创建者:   taojinlei
 * 创建时间:  2017/3/27下午3:37
 * 描述:     TODO
 */
public class NewsData {
    private String title;
    private String source;
    private String imgUrl;
    private String topUrl;
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTopUrl() {
        return topUrl;
    }

    public void setTopUrl(String topUrl) {
        this.topUrl = topUrl;
    }
}
