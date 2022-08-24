package org.example.controller;

import org.example.model.dao.UserDao;
import org.example.model.entities.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DonorController {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    UserDao userDao = applicationContext.getBean("userDao", UserDao.class);

    public User getUserById(int userId) {

        return userDao.getUserById(userId);
    }

    public void updateUser(String username, String age, String email, String phone, String bg, int userId) {

        User user = new User();
        user.setUserName(username);
        user.setAge(age);
        user.setPhone(phone);
        user.setEmail(email);
        user.setBg(bg);
        user.setUserId(userId);
        userDao.updateUser(user);

    }

    public void updatePass(int userId, String password) {

        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        userDao.updatePass(user);
    }

    public void updateEligibility(String eligibility, int userId) {
        userDao.updateEligibility(eligibility, userId);
    }

    public void updateLastBlood(String lastBlood, int userId) {
        userDao.updateLastBlood(lastBlood, userId);
    }

    public String showLastBlood(int userId) {
        return userDao.showLastBlood(userId);
    }
}
