package org.example.view;

import org.example.model.entities.User;
import org.example.view.utilities.Frame;

import javax.swing.*;

public class PatientDash extends JFrame {
/*
    private int userId;*/
    private int yValue = 20;
    private static final int boxHeight  = 30;
    private static final int boxWidth  = 200;

    public PatientDash(User user) {

        Frame patientFrame = new Frame();

        JButton profileButton = patientFrame.getButton("Show Profile", 140, yValue, boxWidth, boxHeight);
        patientFrame.add(profileButton);

        JButton bloodSearchButton = patientFrame.getButton("Blood Search", 140, shiftYValue(), boxWidth, boxHeight);
        patientFrame.add(bloodSearchButton);

        JButton backButton = patientFrame.getButton("Back", 140, yValue + 300, boxWidth, boxHeight);
        patientFrame.add(backButton);

        backButton.addActionListener(e -> {

            patientFrame.dispose();
            new Login();
        });

        profileButton.addActionListener(e -> {

            patientFrame.dispose();
            new Profile(user);
        });

        bloodSearchButton.addActionListener(e -> {

            patientFrame.dispose();
            new BloodSearch(user);
        });





    }
    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }

}
