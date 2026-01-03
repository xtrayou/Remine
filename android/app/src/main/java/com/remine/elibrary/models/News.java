package com.remine.elibrary.models;

public class News {
    private int id;
    private String title;
    private String subtitle;
    private int imageResId;

    public News(int id, String title, String subtitle, int imageResId) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.imageResId = imageResId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
