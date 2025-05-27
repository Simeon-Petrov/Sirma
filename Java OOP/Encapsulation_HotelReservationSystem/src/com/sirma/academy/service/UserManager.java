package com.sirma.academy.service;

import com.sirma.academy.model.User;

import java.util.HashMap;
import java.util.Map;
//import java.util.*;

public class UserManager {
    private Map<String, User> users = new HashMap<>();

    public User register(String username, String password) {
        if (users.containsKey(username)) return null;
        User user = new User(username, password);
        users.put(username, user);
        return user;
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
