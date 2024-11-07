package com.matrosov.service;

import com.matrosov.dao.UserDao;
import com.matrosov.entity.User;

import java.util.List;

public class UserService {
    private final UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public void add(User user) {
        dao.add(user);
    }

    public void updateUser(User user) {
        dao.save(user);
    }

    public List<User> findAll() {
        return dao.findAll();
    }

    public boolean delete(Integer id) {
        return dao.delete(id);
    }
}
