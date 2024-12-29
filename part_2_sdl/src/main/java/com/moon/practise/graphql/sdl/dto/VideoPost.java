package com.moon.practise.graphql.sdl.dto;

public class VideoPost extends MultiMediaPost{
    private Integer lengthInSeconds;

    public VideoPost(String id, String createdUserId, String mediaLocation, Integer lengthInSeconds) {
        super(id, createdUserId, mediaLocation);
        this.lengthInSeconds = lengthInSeconds;
    }

    public VideoPost() {
    }

    public Integer getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(Integer lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }
}
