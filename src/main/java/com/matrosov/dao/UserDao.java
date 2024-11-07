package com.matrosov.dao;

import com.matrosov.entity.User;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    List<User> userList = new ArrayList<>();

    public void add(User user) {
        userList.add(user);
    }

    @SneakyThrows
    public boolean delete(Integer id) {
        try (Connection connection = DriverManager.getConnection("url", "username", "password")) {
            return true;
        }
    }

    public List<User> findAll() {
        return userList;
    }

    public void save(User user) {
        System.out.println();
    }
}
