package com.zadanie2.demo.service;

import com.zadanie2.demo.entity.User;

import java.util.List;

public interface UserService{
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);

    public void disk_SizeIncrease(int userId, int number);

    public void addFile(int userId, String text);

    public void removeFile(int userId);
}
