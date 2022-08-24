package org.example.view;

import org.example.controller.DonorController;
import org.example.model.entities.User;
import org.example.view.utilities.Frame;

import javax.swing.*;
import java.time.LocalDate;

public class DonorDash extends JFrame {
/*
    private int userId;*/
    private int yValue = 20;
    private static final int boxHeight  = 30;
    private static final int boxWidth  = 200;

    public DonorDash(User user) {

        Frame donorFrame = new Frame();
        JButton profileButton = donorFrame.getButton("Show Profile", 140, yValue, boxWidth, boxHeight);
        donorFrame.add(profileButton);

        JButton bloodReqButton = donorFrame.getButton("Blood Donation Request", 140, shiftYValue(), boxWidth, boxHeight);
        donorFrame.add(bloodReqButton);

        JButton bloodTestButton = donorFrame.getButton("Blood Test", 140, shiftYValue(), boxWidth, boxHeight);
        donorFrame.add(bloodTestButton);

        JButton backButton = donorFrame.getButton("Back", 140, yValue + 300, boxWidth, boxHeight);
        donorFrame.add(backButton);

        backButton.addActionListener(e -> {

            donorFrame.dispose();
            new Login();
        });

        profileButton.addActionListener(e -> {

            donorFrame.dispose();
            new Profile(user);
        });

        bloodReqButton.addActionListener(e -> {

            DonorController donorController = new DonorController();

            updateEligibility(donorController.showLastBlood(user.getUserName()), user.getUserName());
            User updateUser = donorController.getUserByName(user.getUserName());
            if(updateUser.getEligibility().equals("YES")) {
                donorFrame.dispose();
                new BloodDonate(user);
            }
        });

        bloodTestButton.addActionListener(e -> {

            donorFrame.dispose();
            new BloodTest(user);
        });





    }
    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }

    public void updateEligibility(String lastBlood, String username) {

        DonorController donorController = new DonorController();
        if(lastBlood.equals("NULL"))
            donorController.updateEligibility("YES", username);
        else {
            LocalDate lastDate = LocalDate.parse(lastBlood);
            LocalDate currentDate = LocalDate.now();
            int month = currentDate.getMonth().getValue() - lastDate.getMonth().getValue();
            int year = currentDate.getYear() - lastDate.getYear();

            if(month > 4 && year >= 0)
                donorController.updateEligibility("YES", username);
            else
                donorController.updateEligibility("NO", username);
        }

    }

}
