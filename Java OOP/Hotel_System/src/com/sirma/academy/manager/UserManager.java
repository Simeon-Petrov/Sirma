package com.sirma.academy.manager;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.sirma.academy.model.User;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserManager {
    private static final String USERS_FILE = "src/com/sirma/academy/data/users.json";
    private final Scanner scanner = new Scanner(System.in);
    private List<User> users = new ArrayList<>();

    public void loadUsers() {
        try {
            String json = new String(Files.readAllBytes(Paths.get(USERS_FILE)));
            users = new Gson().fromJson(json, new TypeToken<List<User>>(){}.getType());
            if (users == null) users = new ArrayList<>();

        } catch (IOException e) {
            users = new ArrayList<>();
            System.out.println("Error loading users.");
        }
    }

    public void saveUsers() {
        try (FileWriter writer = new FileWriter(USERS_FILE)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(users, writer);
        } catch (IOException e) {
            System.out.println("Error saving users.");
        }
    }

    public void register() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (User u : users) {
            if (u.getUsername().equals(username)) {
                System.out.println("Username already exists.");
                return;
            }
        }

        users.add(new User(username, password, false, "Never"));
        saveUsers();
        System.out.println("Registered successfully.");
    }

    public User login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                user.setLastLogin(date);
                saveUsers();
                return user;
            }
        }
        System.out.println("Invalid credentials.");
        return null;
    }
}