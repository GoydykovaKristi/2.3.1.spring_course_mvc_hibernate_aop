package com.zaurtregulov.spring.mvc_hibernate_aop.dao;

import com.zaurtregulov.spring.mvc_hibernate_aop.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {

        entityManager.persist(user);
    }


    @Override
    public User getUserById(long id) {

         User user = entityManager.find(User.class, id);
         return  user;
    }

    @Override
    public void updateUser(User updateUser, long id) {
        User personToBeUpdated = getUserById(id);
        personToBeUpdated.setName(updateUser.getName());
        personToBeUpdated.setSurname(updateUser.getSurname());
        personToBeUpdated.setAge(updateUser.getAge());
        personToBeUpdated.setEmail(updateUser.getEmail());
    }

    @Override
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

}
