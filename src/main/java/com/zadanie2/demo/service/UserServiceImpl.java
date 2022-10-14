package com.zadanie2.demo.service;

import com.zadanie2.demo.dao.UserDAO;
import com.zadanie2.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Transactional
    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    @Transactional
    @Override
    public void disk_SizeIncrease(int userId, int number) {
        userDAO.disk_SizeIncrease(userId,number);
    }

    @Transactional
    @Override
    public void addFile(int userId, String text) {
        userDAO.addFile(userId,text);
    }

    @Transactional
    @Override
    public void removeFile(int userId) {
        userDAO.removeFile(userId);
    }
}
