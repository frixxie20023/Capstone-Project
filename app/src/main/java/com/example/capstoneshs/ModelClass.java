package com.example.capstoneshs;

public class ModelClass {

    private  int imageResource;
    private  String title;
    private String body;
    private String userId;

    public ModelClass(int imageResource, String title, String body,String userId) {
        this.imageResource = imageResource;
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getUserId() {
        return userId;
    }
}
