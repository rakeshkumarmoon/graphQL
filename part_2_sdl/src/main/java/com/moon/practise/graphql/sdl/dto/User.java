package com.moon.practise.graphql.sdl.dto;

import java.util.List;

public record User(String id, String name, String email, Gender gender, List<String> friendList) {
}
