package com.moon.practise.graphql.sdl.controller;

import com.moon.practise.graphql.sdl.dao.PostDao;
import com.moon.practise.graphql.sdl.dao.UserDao;
import com.moon.practise.graphql.sdl.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @QueryMapping
    public Collection<User> users() {
        log.info("users called.");
        return userDao.getUsers();
    }

    @QueryMapping
    public User getUserById(@Argument String id) {
        log.info("getUserById called for {}.",id);
        return userDao.getUserById(id);
    }

    @SchemaMapping
    public List<User> friendList(User user) {
        log.info("friendList called for user : {}", user.id());
        List<User> friendList = new ArrayList<>();
        if (user.friendList() != null) {
            for (String uid : user.friendList()) {
                friendList.add(userDao.getUserById(uid));
            }
        }
        log.info("No of friend : {}", friendList.size());
        return friendList;
    }
}
