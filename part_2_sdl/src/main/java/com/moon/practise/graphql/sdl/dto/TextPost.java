package com.moon.practise.graphql.sdl.dto;

public class TextPost extends Post{
    private String text;

    public TextPost(String id, String createdUserId, String text) {
        super(id, createdUserId);
        this.text = text;
    }

    public TextPost() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
