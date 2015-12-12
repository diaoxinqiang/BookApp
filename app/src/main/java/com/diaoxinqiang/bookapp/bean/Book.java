package com.diaoxinqiang.bookapp.bean;

public class Book {
    private String title;
    private String catalog;
    private String tags;
    private String sub1;
    private String sub2;
    private String img;
    private String reading;
    private String online;
    private String bytime;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setSub1(String sub1) {
        this.sub1 = sub1;
    }

    public void setSub2(String sub2) {
        this.sub2 = sub2;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public void setBytime(String bytime) {
        this.bytime = bytime;
    }

    public String getTitle() {
        return title;
    }

    public String getCatalog() {
        return catalog;
    }

    public String getTags() {
        return tags;
    }

    public String getSub1() {
        return sub1;
    }

    public String getSub2() {
        return sub2;
    }

    public String getImg() {
        return img;
    }

    public String getReading() {
        return reading;
    }

    public String getOnline() {
        return online;
    }

    public String getBytime() {
        return bytime;
    }

    @Override
    public String toString() {
        return "DataEntity{" +
                "title='" + title + '\'' +
                ", catalog='" + catalog + '\'' +
                ", tags='" + tags + '\'' +
                ", sub1='" + sub1 + '\'' +
                ", sub2='" + sub2 + '\'' +
                ", img='" + img + '\'' +
                ", reading='" + reading + '\'' +
                ", online='" + online + '\'' +
                ", bytime='" + bytime + '\'' +
                '}';
    }
}

