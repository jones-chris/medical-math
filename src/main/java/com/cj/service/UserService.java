package com.cj.service;


import com.cj.model.User;

public interface UserService {
    User findByUsername(String username);
    boolean add(User user);
    boolean updatePassword(User user);
    boolean addFavorite(Long id, User user);
    boolean deleteFavorite(Long id, User user);
}
