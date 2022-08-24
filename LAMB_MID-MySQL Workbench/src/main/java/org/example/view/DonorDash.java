package org.example.view;

import org.example.controller.DonorController;
import org.example.model.entities.User;
import org.example.view.utilities.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class DonorDash extends JFrame {

    private int userId;
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

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                donorFrame.dispose();
                new Login();
            }
        });

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                donorFrame.dispose();
                new Profile(user);
            }
        });

        bloodReqButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DonorController donorController = new DonorController();

                updateEligibility(donorController.showLastBlood(user.getUserId()), user.getUserId());
                User updateUser = donorController.getUserById(user.getUserId());
                if(updateUser.getEligibility().equals("YES")) {
                    donorFrame.dispose();
                    new BloodDonate(user);
                }
            }
        });

        bloodTestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                donorFrame.dispose();
                new BloodTest(user);
            }
            });





    }
    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }

    public void updateEligibility(String lastBlood, int userId) {

        DonorController donorController = new DonorController();
        if(lastBlood.equals("NULL"))
            donorController.updateEligibility("YES", userId);
        else {
            LocalDate lastDate = LocalDate.parse(lastBlood);
            LocalDate currentDate = LocalDate.now();
            int month = currentDate.getMonth().getValue() - lastDate.getMonth().getValue();
            int year = currentDate.getYear() - lastDate.getYear();

            if(month > 4 && year >= 0)
                donorController.updateEligibility("YES", userId);
            else
                donorController.updateEligibility("NO", userId);
        }

    }

}
