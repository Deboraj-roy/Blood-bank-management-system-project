package org.example.view;

import org.example.controller.DonorController;
import org.example.model.entities.User;
import org.example.view.utilities.EditProfile;
import org.example.view.utilities.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile {

    private int yValue = 20;
    private static final int boxHeight = 30;
    private static final int boxWidth = 200;

    public Profile(User user) {

        Frame profileFrame = new Frame();

        JLabel profile = profileFrame.getLabel("Profile Info - ", 20, yValue, 70, 70);
        profileFrame.add(profile);

        JLabel username = profileFrame.getLabel("Username:", 20, shiftYValue(), 70, 70);
        profileFrame.add(username);

        JLabel usernameVal = profileFrame.getLabel(user.getUserName(), 120, yValue, 70, 70);
        profileFrame.add(usernameVal);

        JLabel age = profileFrame.getLabel("Age: ", 20, shiftYValue(), 70, 70);
        profileFrame.add(age);

        JLabel ageVal = profileFrame.getLabel(user.getAge() ,120, yValue + 20, boxWidth, boxHeight);
        profileFrame.add(ageVal);

        JLabel role = profileFrame.getLabel("Role: ", 20, shiftYValue(), 70, 70);
        profileFrame.add(role);

        JLabel roleVal = profileFrame.getLabel(user.getRole() ,120, yValue + 20, boxWidth, boxHeight);
        profileFrame.add(roleVal);

        JLabel email = profileFrame.getLabel("Email: ", 20, shiftYValue(), 70, 70);
        profileFrame.add(email);

        JLabel emailVal = profileFrame.getLabel(user.getEmail(), 120, yValue, 170, 70);
        profileFrame.add(emailVal);

        JLabel phone = profileFrame.getLabel("Phone: ", 20, shiftYValue(), 70, 70);
        profileFrame.add(phone);

        JLabel phoneVal = profileFrame.getLabel(user.getPhone(), 120, yValue, 170, 70);
        profileFrame.add(phoneVal);

        JLabel bloodgroup = profileFrame.getLabel("Blood Group: ", 20, shiftYValue(), 100, 70);
        profileFrame.add(bloodgroup);

        JLabel bgVal = profileFrame.getLabel(user.getBg(), 120, yValue, 170, 70);
        profileFrame.add(bgVal);

        JButton editProfileButton = profileFrame.getButton("Edit Profile", 140, yValue + 200, boxWidth, boxHeight);
        profileFrame.add(editProfileButton);

        JButton deleteProfileButton = profileFrame.getButton("Delete Profile", 140, shiftYValue() + 200, boxWidth, boxHeight);
        profileFrame.add(deleteProfileButton);

        JButton changePassButton = profileFrame.getButton("Change Password", 140, shiftYValue() + 200, boxWidth, boxHeight);
        profileFrame.add(changePassButton);

        JButton backButton = profileFrame.getButton("Back", 140, yValue + 300, boxWidth, boxHeight);
        profileFrame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                profileFrame.dispose();
                new DonorDash(user);
            }
        });

        editProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                profileFrame.dispose();
                new EditProfile(user);
            }
        });

        changePassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                profileFrame.dispose();
                new ChangePass(user);
            }
        });

    }
    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }
}
