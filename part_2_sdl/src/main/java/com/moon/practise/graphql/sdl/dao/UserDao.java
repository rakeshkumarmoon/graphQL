package com.moon.practise.graphql.sdl.dao;

import com.moon.practise.graphql.sdl.dto.Gender;
import com.moon.practise.graphql.sdl.dto.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDao {
    private final Map<String, User> userMap = new HashMap<>();

    @PostConstruct
    public void init() {
        userMap.put("U-1", new User("U-1", "Aman", "aman@gmail.com", Gender.MALE, List.of("U-2")));
        userMap.put("U-2", new User("U-2", "Sohan", "sohan123@gmail.com", Gender.MALE, List.of("U-1", "U-3")));
        userMap.put("U-3", new User("U-3", "Arun", "arun@gmail.com", Gender.MALE, null));
        userMap.put("U-4", new User("U-4", "Divya", "divya@gmail.com", Gender.FEMALE, List.of("U-3")));
        userMap.put("U-5", new User("U-5", "Mac", "mac@gmail.com", Gender.MALE, List.of("U-1", "U-6")));
        userMap.put("U-6", new User("U-6", "Tom", null, Gender.MALE, List.of()));
    }

    public Collection<User> getUsers() {
        return userMap.values();
    }

    public User getUserById(String id) {
        return userMap.get(id);
    }
}
