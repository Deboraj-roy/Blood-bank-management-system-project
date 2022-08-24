package org.example.controller;

import org.example.model.dao.UserDao;
import org.example.model.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginController {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
/*
    public User authorizeUser(String username, String password) {


        User user = new User();
        user.setUserName(username);
        user.setPassword(password);

        return userDao.authorizeUser(user);
    }*/
    public String authorizeUser(String username, String password) {


        User user = new User();
        user.setUserName(username);
        user.setPassword(password);

        return userDao.authorizeUser(user.getUserName(),password);
    }

    public User getUserByName(String username) {

        return userDao.getUserByName(username);
    }
}
