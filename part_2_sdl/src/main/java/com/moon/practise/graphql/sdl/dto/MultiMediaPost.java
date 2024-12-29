package com.moon.practise.graphql.sdl.dto;

public abstract class MultiMediaPost extends Post{
    private String mediaLocation;

    public MultiMediaPost(String id, String createdUserId, String mediaLocation) {
        super(id, createdUserId);
        this.mediaLocation = mediaLocation;
    }

    public MultiMediaPost() {
    }

    public String getMediaLocation() {
        return mediaLocation;
    }

    public void setMediaLocation(String mediaLocation) {
        this.mediaLocation = mediaLocation;
    }
}
