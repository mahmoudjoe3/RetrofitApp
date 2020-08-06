package com.mahmoudjoe333.retrofitapp.pojo;

public class PostModel {
    private int userId,id;
    private String title,body;

    public PostModel(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public PostModel(PostModel p) {
        this.id=p.id;
        this.userId=p.userId;
        this.title=p.title;
        this.body=p.body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
