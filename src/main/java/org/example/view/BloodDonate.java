package org.example.view;

import org.example.controller.BloodController;
import org.example.controller.DonorController;
import org.example.model.entities.User;
import org.example.view.utilities.Frame;

import javax.swing.*;
import java.time.LocalDate;

public class BloodDonate extends JFrame {
    private int yValue = 20;
    private static final int boxHeight = 30;
    private static final int boxWidth = 200;

    public BloodDonate(User user) {

        Frame bloodDonateFrame = new Frame();

        JLabel platy = bloodDonateFrame.getLabel("Platelet Counts", 20, yValue, 70, 70);
        bloodDonateFrame.add(platy);

        JTextField platyTB = bloodDonateFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        bloodDonateFrame.add(platyTB);

        JLabel haemoglobin = bloodDonateFrame.getLabel("Haemoglobin: ", 20, shiftYValue(), 70, 70);
        bloodDonateFrame.add(haemoglobin);

        JTextField haemoglobinTB = bloodDonateFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        bloodDonateFrame.add(haemoglobinTB);

        JLabel lymphocytes = bloodDonateFrame.getLabel("Lymphocytes: ", 20, shiftYValue(), 70, 70);
        bloodDonateFrame.add(lymphocytes);

        JTextField lymphocytesTB = bloodDonateFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        bloodDonateFrame.add(lymphocytesTB);

        JButton saveButton = bloodDonateFrame.getButton("Save", 140, yValue + 200, boxWidth, boxHeight);
        bloodDonateFrame.add(saveButton);

        JButton backButton = bloodDonateFrame.getButton("Back", 140, yValue + 300, boxWidth, boxHeight);
        bloodDonateFrame.add(backButton);

        backButton.addActionListener(e -> {

            bloodDonateFrame.dispose();
            new Login();
        });

        saveButton.addActionListener(e -> {

            BloodController bloodController = new BloodController();
            DonorController donorController = new DonorController();

            if(bloodController.checkBloodCondition(platyTB.getText(), haemoglobinTB.getText(), lymphocytesTB.getText()).equals("GOOD")) {
                bloodController.insertBlood(user.getUserName() , Integer.parseInt(platyTB.getText()), Double.parseDouble(haemoglobinTB.getText()), Integer.parseInt(lymphocytesTB.getText()));
                bloodDonateFrame.dispose();
                donorController.updateEligibility("NO", user.getUserName());
                donorController.updateLastBlood(LocalDate.now().toString(), user.getUserName());
                User updateUser = donorController.getUserByName(user.getUserName());
                //updateUser.getUserName(user.getUserName());
                new DonorDash(updateUser);
            }
            else {
                System.out.println("Error Bad Blood");

            }

        });



    }
    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }

}
