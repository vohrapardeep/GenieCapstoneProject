package com.example.test.ui.JoinUs;
public class helperUpload {


    public String nam;
    public String url;

    public helperUpload(){

    }

    public helperUpload(String nam, String url) {
        this.nam = nam;
        this.url = url;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
