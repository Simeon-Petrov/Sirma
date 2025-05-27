package com.sirma.academy.model;

public class User {
    private String username;
    private String password;
    private boolean admin;
    private String lastLogin;

    public User(String username, String password, boolean admin, String lastLogin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.lastLogin = lastLogin;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public boolean isAdmin() { return admin; }
    public String getLastLogin() { return lastLogin; }
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
}