package org.example;

import org.example.domain.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientProfile {

    private int yValue = 20;
    private static final int boxHeight = 30;
    private static final int boxWidth = 200;

    public ClientProfile(User user) {

        Frame profileFrame = new Frame();

        JLabel profile = profileFrame.getLabel("Profile Info - ", 20, yValue, 70, 70);
        profileFrame.add(profile);

        JLabel usertype = profileFrame.getLabel("User Type:", 20, shiftYValue(), 70, 70);
        profileFrame.add(usertype);

        JLabel usertypeVal = profileFrame.getLabel(user.getUsertype(), 120, yValue, 70, 70);
        profileFrame.add(usertypeVal);

        JLabel name = profileFrame.getLabel("Name:", 20, shiftYValue(), 70, 70);
        profileFrame.add(name);

        JLabel nameVal = profileFrame.getLabel(user.getName(), 120, yValue, 70, 70);
        profileFrame.add(nameVal);

        JLabel email = profileFrame.getLabel("Email: ", 20, shiftYValue(), 70, 70);
        profileFrame.add(email);

        JLabel emailVal = profileFrame.getLabel(user.getEmail() ,120, yValue + 20, boxWidth, boxHeight);
        profileFrame.add(emailVal);

        JLabel nid = profileFrame.getLabel("NID: ", 20, shiftYValue(), 70, 70);
        profileFrame.add(nid);

        JLabel nidVal = profileFrame.getLabel(user.getNid() ,120, yValue + 20, boxWidth, boxHeight);
        profileFrame.add(nidVal);

        JLabel birthdate = profileFrame.getLabel("Birthdate: ", 20, shiftYValue(), 70, 70);
        profileFrame.add(birthdate);

        JLabel birthdateVal = profileFrame.getLabel(user.getBirthdate(), 120, yValue, 170, 70);
        profileFrame.add(birthdateVal);

        JLabel bloodgroup = profileFrame.getLabel("Blood Group: ", 20, shiftYValue(), 70, 70);
        profileFrame.add(bloodgroup);

        JLabel bloodgroupVal = profileFrame.getLabel(user.getBloodgroup(), 120, yValue, 170, 70);
        profileFrame.add(bloodgroupVal);

        JLabel phone = profileFrame.getLabel("Phone: ", 20, shiftYValue(), 100, 70);
        profileFrame.add(phone);

        JLabel phoneVal = profileFrame.getLabel(user.getPhone(), 120, yValue, 170, 70);
        profileFrame.add(phoneVal);

        JLabel address = profileFrame.getLabel("Address: ", 20, shiftYValue(), 100, 70);
        profileFrame.add(address);

        JLabel addressVal = profileFrame.getLabel(user.getAddress(), 120, yValue, 170, 70);
        profileFrame.add(addressVal);


        JLabel gender = profileFrame.getLabel("Gender: ", 20, shiftYValue(), 100, 70);
        profileFrame.add(gender);

        JLabel genderVal = profileFrame.getLabel(user.getGender(), 120, yValue, 170, 70);
        profileFrame.add(genderVal);









        JButton editProfileButton = profileFrame.getButton("Edit Profile", 140, yValue + 200, boxWidth, boxHeight);
        profileFrame.add(editProfileButton);

       /* JButton deleteProfileButton = profileFrame.getButton("Delete Profile", 140, shiftYValue() + 200, boxWidth, boxHeight);
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
        });*/

        editProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                profileFrame.dispose();
                new EditProfile(user);
            }
        });


    }
    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }
}
