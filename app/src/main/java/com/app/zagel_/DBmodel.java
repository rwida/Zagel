package com.app.zagel_;

import android.graphics.Bitmap;

public class DBmodel {

    Bitmap ourImage;
    String imgDes;
    String typenews;
    String tvTime;
    String link;

    public DBmodel(String tvTime) {
        this.tvTime = tvTime;
    }

    public DBmodel(Bitmap ourImage , String imgDes , String typenews , String link) {
        this.ourImage = ourImage;
        this.imgDes = imgDes;
        this.typenews = typenews;
        this.link = link;
    }

    public Bitmap getOurImage() {
        return ourImage;
    }

    public void setOurImage(Bitmap ourImage) {
        this.ourImage = ourImage;
    }

    public String getImgDes() {
        return imgDes;
    }

    public void setImgDes(String imgDes) {
        this.imgDes = imgDes;
    }

    public String getTvTime() {
        return tvTime;
    }

    public void setTvTime(String tvTime) {
        this.tvTime = tvTime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
