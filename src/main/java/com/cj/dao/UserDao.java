package com.cj.dao;


import com.cj.model.User;

public interface UserDao {
    User findByUsername(String username);
    boolean add(User user);
    boolean update(User user);
    boolean delete(Long id);
    boolean addFavorite(Long id);
    boolean deleteFavorite(Long id);
}
