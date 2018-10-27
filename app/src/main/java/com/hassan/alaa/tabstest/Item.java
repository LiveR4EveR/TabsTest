package com.hassan.alaa.tabstest;

public class Item {
    private String title;
    private String desc;
    private int imgId;

    public Item (String title, String desc, int imgId){
        setTitle(title);
        setDesc(desc);
        setImgId(imgId);
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }
    public String getDesc() {
        return desc;
    }
    public int getImgId() {
        return imgId;
    }
}
