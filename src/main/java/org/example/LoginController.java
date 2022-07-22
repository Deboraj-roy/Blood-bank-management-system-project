package org.example;
import org.example.dao.UserDao;
import org.example.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginController {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    UserDao userDao = applicationContext.getBean("userDao", UserDao.class);



    public User validation(String email, String password) {


        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        return userDao.validation(user);
    }

    public User getUserByEmail(String email) {

        return userDao.validationByEmail(email);
    }

}
