package com.zaurtregulov.spring.mvc_hibernate_aop.service;

import com.zaurtregulov.spring.mvc_hibernate_aop.dao.UserDAO;
import com.zaurtregulov.spring.mvc_hibernate_aop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {

        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {

        return userDAO.getAllUsers();
    }

    @Override
    public void saveUser(User user) {

         userDAO.saveUser(user);
    }

    @Override
    public void updateUser(User user, long id) {

        userDAO.updateUser(user, id);
    }

    @Override
    public User getUserById(long id) {

        return userDAO.getUserById(id);
    }

    @Override
    public void deleteUser(long id) {

        userDAO.deleteUser(id);
    }
}
