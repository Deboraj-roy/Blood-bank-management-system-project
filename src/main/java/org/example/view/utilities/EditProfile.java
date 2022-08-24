package org.example.view.utilities;

import org.example.controller.DonorController;
import org.example.controller.RegController;
import org.example.model.entities.User;
import org.example.view.Login;
import org.example.view.Profile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProfile {
    private int yValue = 20;
    private static final int boxHeight = 30;
    private static final int boxWidth = 200;
    private static final String bgVal [] = {"A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-", "AB-"};

    public EditProfile(User user) {

        Frame editProfileFrame = new Frame();

        JLabel editProfile = editProfileFrame.getLabel("Edit Profile...", 20, yValue, 70, 70);
        editProfileFrame.add(editProfile);

       /* JLabel username = editProfileFrame.getLabel("Username", 20, shiftYValue(), 70, 70);
        editProfileFrame.add(username);

        JTextField userTB = editProfileFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        userTB.setText(user.getUserName());
        editProfileFrame.add(userTB);
*/
        JLabel age = editProfileFrame.getLabel("Age:", 20, shiftYValue(), 70, 70);
        editProfileFrame.add(age);

        JTextField ageTB = editProfileFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        ageTB.setText(user.getAge());
        editProfileFrame.add(ageTB);

        JLabel email = editProfileFrame.getLabel("Email: ", 20, shiftYValue(), 70, 70);
        editProfileFrame.add(email);

        JTextField emailTB = editProfileFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        emailTB.setText(user.getEmail());
        editProfileFrame.add(emailTB);

        JLabel phone = editProfileFrame.getLabel("Phone: ", 20, shiftYValue(), 70, 70);
        editProfileFrame.add(phone);

        JTextField phoneTB = editProfileFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        phoneTB.setText(user.getPhone());
        editProfileFrame.add(phoneTB);

        JLabel bloodgroup = editProfileFrame.getLabel("Blood Group: ", 20, shiftYValue(), 100, 70);
        editProfileFrame.add(bloodgroup);

        System.out.println(user.getBg());

        JComboBox bloodTB = new JComboBox(bgVal);
        bloodTB.setBounds(120, yValue + 20, boxWidth, boxHeight);
        bloodTB.setSelectedItem(user.getBg());
        editProfileFrame.add(bloodTB);

        JButton submitButton = editProfileFrame.getButton("Update", 140, yValue + 200, boxWidth, boxHeight);
        editProfileFrame.add(submitButton);

        JButton backButton = editProfileFrame.getButton("Back", 140, yValue + 300, boxWidth, boxHeight);
        editProfileFrame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                editProfileFrame.dispose();
                new Profile(user);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DonorController donorController = new DonorController();

                donorController.updateUser(ageTB.getText(), emailTB.getText(), phoneTB.getText(), bloodTB.getSelectedItem().toString(), user.getUserName());
                editProfileFrame.dispose();
                User updateUser = donorController.getUserByName(user.getUserName());
                updateUser.setUserName(user.getUserName());
                new Profile(updateUser);
            }
        });



    }
    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }
}
