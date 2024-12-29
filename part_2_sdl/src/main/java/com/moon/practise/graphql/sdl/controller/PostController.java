package com.moon.practise.graphql.sdl.controller;

import com.moon.practise.graphql.sdl.dao.PostDao;
import com.moon.practise.graphql.sdl.dao.UserDao;
import com.moon.practise.graphql.sdl.dto.Post;
import com.moon.practise.graphql.sdl.dto.PostFilter;
import com.moon.practise.graphql.sdl.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class PostController{
    private static final Logger log = LoggerFactory.getLogger(PostController.class);


    private final PostDao postDao;
    private final UserDao userDao;

    public PostController(PostDao postDao, UserDao userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @QueryMapping
    public List<Post> postsByFilter(@Argument PostFilter postFilter){
        log.info("postsByFilter called for input :{}",postFilter);
        Collection<Post> postsForUser=postDao.getPostByUserId(postFilter.userId());
        log.info("Total:{} post for user:{} found.",postsForUser.size(),postFilter.userId());
        return new ArrayList<>(postsForUser).subList(0, postFilter.limit()>postsForUser.size()?postsForUser.size():postFilter.limit());
    }

    @QueryMapping
    public Post postById(@Argument String id){
        log.info("postById called for id :{}",id);
        return postDao.getPostById(id);
    }

    @QueryMapping
    public Collection<Post> posts(){
        log.info("posts called..");
        return postDao.getAllPost();
    }

    @SchemaMapping
    public User createdUser(Post post){
        log.info("createdUser called for postId:{} and userId:{}",post.getId(),post.getCreatedUserId());
        return userDao.getUserById(post.getCreatedUserId());
    }
}
