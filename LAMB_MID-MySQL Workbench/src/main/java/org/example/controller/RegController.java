package org.example.controller;

import org.example.model.dao.UserDao;
import org.example.model.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RegController {


    public void insertUser(String username, String password, String role, String age, String email, String phone, String bg, String eligibility) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);

        User user = new User(username, password, role, age, email, phone, bg, eligibility);
        userDao.insertUser(user);

    }

}
