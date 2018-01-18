package com.cj.model;


import java.util.List;

public class User {
    private String username;
    private String password;
    private String[] roles;
    private List<Long> favorites;

    public User() {}

    public User(String username, String password, String[] roles, List<Long> favorites) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.favorites = favorites;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public List<Long> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Long> favorites) {
        this.favorites = favorites;
    }
}
