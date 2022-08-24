package org.example.controller;

import org.example.model.dao.BloodDao;
import org.example.model.entities.Blood;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BloodController {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
    BloodDao bloodDao = applicationContext.getBean("bloodDao", BloodDao.class);
    public void insertBlood(String donorId, int platelet, double haemoglobin, int lymphocytes) {

        Blood blood = new Blood(donorId, platelet, haemoglobin, lymphocytes);
        bloodDao.insertBlood(blood);

    }

    public List<Blood> getAllBlood() {
        return bloodDao.getAllBlood();
    }

    public Blood getBlood(String bloodId) {
        return bloodDao.getBlood(bloodId);
    }

    public String checkBloodCondition(String platy, String haemo, String lymph) {

        int platyVal = Integer.parseInt(platy);
        double haemoVal = Double.parseDouble(haemo);
        int lymphVal = Integer.parseInt(lymph);

        if((platyVal >= 150 && platyVal <= 400) && (haemoVal >= 13.5 && haemoVal <= 17.5) && (lymphVal >= 20 && lymphVal <= 40))
            return "GOOD";
        else
            return "BAD";
    }
}
