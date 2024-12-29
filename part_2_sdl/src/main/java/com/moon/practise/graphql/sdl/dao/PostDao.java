package com.moon.practise.graphql.sdl.dao;

import com.moon.practise.graphql.sdl.dto.*;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class PostDao {

    private final Map<String, Post> postMap = new HashMap<>();


    @PostConstruct
    public void init() {
        postMap.put("P-1", new TextPost("P-1", "U-1", "Hello World. This is my first post."));
        postMap.put("P-2", new ImagePost("P-2", "U-3", "http://mediaLocation-ImagePost-2"));
        postMap.put("P-3", new VideoPost("P-3", "U-2", "http://mediaLocation-VideoPost-3", 10));
        postMap.put("P-4", new VideoPost("P-4", "U-1", "http://mediaLocation-VideoPost-4", 15));
    }

    public Collection<Post> getAllPost() {
        return postMap.values();
    }

    public Post getPostById(String id) {
        return postMap.get(id);
    }

    public Collection<Post> getPostByUserId(String userId) {
        return postMap.values().stream().filter(p -> p.getCreatedUserId().equals(userId)).toList();
    }

}
