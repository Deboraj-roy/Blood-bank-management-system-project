package org.example.view;

import org.example.controller.DonorController;
import org.example.model.entities.User;
import org.example.view.utilities.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePass {

    private int yValue = 20;
    private static final int boxHeight  = 30;
    private static final int boxWidth  = 200;

    public ChangePass(User user) {
        Frame changePassFrame = new Frame();

        JLabel oldPass = changePassFrame.getLabel("Old Password", 20, yValue, 70, 70);
        changePassFrame.add(oldPass);

        JTextField oldPassTB = changePassFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        changePassFrame.add(oldPassTB);

        JLabel password = changePassFrame.getLabel("Password: ", 20, shiftYValue(), 70, 70);
        changePassFrame.add(password);

        JTextField passwordTB = changePassFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        changePassFrame.add(passwordTB);

        JLabel cpassword = changePassFrame.getLabel("Confirm Password: ", 20, shiftYValue(), 70, 70);
        changePassFrame.add(cpassword);

        JTextField cpasswordTB = changePassFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        changePassFrame.add(cpasswordTB);

        JButton submitButton = changePassFrame.getButton("Submit", 140, yValue + 100, boxWidth, boxHeight);
        changePassFrame.add(submitButton);

        JButton backButton = changePassFrame.getButton("Back", 140, yValue + 300, boxWidth, boxHeight);
        changePassFrame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                changePassFrame.dispose();
                new Profile(user);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DonorController donorController = new DonorController();

                String oldPass = oldPassTB.getText();
                String password = passwordTB.getText();
                String cpassword = cpasswordTB.getText();

                System.out.println(user.getPassword() + " " + oldPass +  " " + password + " " + cpassword);

                if(!(user.getPassword().equals(oldPass))) {
                }
                else {

                    donorController.updatePass(user.getUserId(), password);
                    changePassFrame.dispose();
                    new Login();
                }


            }
        });
    }
    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }
}
