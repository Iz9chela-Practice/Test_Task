package com.zadanie2.demo.dao;

import com.zadanie2.demo.entity.User;
import com.zadanie2.demo.entity.UserFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery(" from User");
        List<User> userList = query.getResultList();
        return userList;
    }

    @Override
    public void saveUser(User user) {
        User user1 = entityManager.merge(user);
        user.setId(user1.getId());
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Query query = entityManager.createQuery("delete from User " +
                "where id =: userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }

    @Override
    public void disk_SizeIncrease(int userId, int number) {
        User user = entityManager.find(User.class, userId);
        if(user != null){
            user.setDiskSize(user.getDiskSize() + number);
        }
    }

    @Override
    public void addFile(int userId, String text) {
        User user = entityManager.find(User.class, userId);
        if(user == null){
            return;
        }
        UserFile userFile = new UserFile(text);
        userFile.setUser(user);
        entityManager.merge(userFile);
    }

    @Override
    public void removeFile(int userId) {
        Query query = entityManager.createQuery("delete from UserFile " +
                    "where user_id  =: userId");
        query.setParameter("userId", userId);
        query.executeUpdate();
//        System.out.println("Success");
    }



}
