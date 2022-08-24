package org.example.controller;

import org.example.model.dao.UserDao;
import org.example.model.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PatientController {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    UserDao userDao = applicationContext.getBean("userDao", UserDao.class);



}
