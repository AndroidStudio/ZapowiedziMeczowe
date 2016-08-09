package com.meczyki.models;

import java.io.Serializable;

/**
 * Created by Przemysław Skitał on 2016-07-17.
 */
public class MainDataModel implements Serializable{

    public static final int HEADER_VIEW_TYPE = 0;
    public static final int VIDEO_VIEW_TYPE = 1;
    public static final int SEPARATOR_VIEW_TYPE = 2;

    private String title;
    private String url;
    private int viewType;
    private String date;
    private String description;
    private String photoUrl;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getUrl() {
        return url;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
