package org.example.controller;

import org.example.model.dao.UserDao;
import org.example.model.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DonorController {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    UserDao userDao = applicationContext.getBean("userDao", UserDao.class);

    public User getUserByName(String username) {

        return userDao.getUserByName(username);
    }

    public void updatePass(String username, String password) {

        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        userDao.updatePass(user);
    }

    public void updateEligibility(String eligibility, String username) {
        userDao.updateEligibility(eligibility, username);
    }

    public void updateLastBlood(String lastBlood, String username) {
        userDao.updateLastBlood(lastBlood, username);
    }

    public String showLastBlood(String username) {
        return userDao.showLastBlood(username);
    }

    public void updateUser(String age, String email, String phone, String bg,String username) {

        User user = new User();
        user.setUserName(username);
        user.setAge(age);
        user.setPhone(phone);
        user.setEmail(email);
        user.setBg(bg);
        userDao.updateUser(user);

    }
}
