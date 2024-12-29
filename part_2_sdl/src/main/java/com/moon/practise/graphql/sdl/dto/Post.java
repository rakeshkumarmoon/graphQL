package com.moon.practise.graphql.sdl.dto;

public abstract class Post {
    private String id;
    private String createdUserId;

    public Post(String id, String createdUserId) {
        this.id = id;
        this.createdUserId = createdUserId;
    }

    public Post() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }
}
