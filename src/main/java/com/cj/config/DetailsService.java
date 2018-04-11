package com.cj.config;

import com.cj.dao.UserDao;
import com.cj.model.User;
import com.cj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class DetailsService implements UserDetailsService, UserService {
    @Autowired private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        try {
            user = userDao.findByUsername(username);
        } catch (EmptyResultDataAccessException ex) {
            user = null;
        }

        if (user == null) {
            throw new UsernameNotFoundException(username + "was not found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList((String[])user.getRoles().toArray()));
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public boolean add(User user) {
        return userDao.add(user);
    }

    @Override
    public boolean updatePassword(User user) {
        return userDao.updatePassword(user);
    }

    @Override
    public boolean addFavorite(Long id, User user) {
        return userDao.addFavorite(id, user);
    }

    @Override
    public boolean deleteFavorite(Long id, User user) {
        return userDao.deleteFavorite(id, user);
    }
}
