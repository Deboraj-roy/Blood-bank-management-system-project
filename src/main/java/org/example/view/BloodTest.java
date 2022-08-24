package org.example.view;

import org.example.controller.BloodController;
import org.example.model.entities.User;
import org.example.view.utilities.Frame;

import javax.swing.*;

public class BloodTest extends JFrame {
    private int yValue = 20;
    private static final int boxHeight = 30;
    private static final int boxWidth = 200;

    public BloodTest(User user) {

        Frame bloodTestFrame = new Frame();

        JLabel check = bloodTestFrame.getLabel("Check Your Blood..", 20, yValue, 120, 70);
        bloodTestFrame.add(check);

        JLabel platy = bloodTestFrame.getLabel("Platelet Counts", 20, shiftYValue(), 120, 70);
        bloodTestFrame.add(platy);

        JTextField platyTB = bloodTestFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        bloodTestFrame.add(platyTB);

        JLabel haemoglobin = bloodTestFrame.getLabel("Haemoglobin: ", 20, shiftYValue(), 120, 70);
        bloodTestFrame.add(haemoglobin);

        JTextField haemoglobinTB = bloodTestFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        bloodTestFrame.add(haemoglobinTB);

        JLabel lymphocytes = bloodTestFrame.getLabel("Lymphocytes: ", 20, shiftYValue(), 120, 70);
        bloodTestFrame.add(lymphocytes);

        JTextField lymphocytesTB = bloodTestFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        bloodTestFrame.add(lymphocytesTB);

        JButton checkButton = bloodTestFrame.getButton("Check", 140, yValue + 240, boxWidth, boxHeight);
        bloodTestFrame.add(checkButton);

        JButton backButton = bloodTestFrame.getButton("Back", 140, yValue + 300, boxWidth, boxHeight);
        bloodTestFrame.add(backButton);

        backButton.addActionListener(e -> {

            bloodTestFrame.dispose();
            new DonorDash(user);
        });

        checkButton.addActionListener(e -> {

            BloodController bloodController = new BloodController();

            JLabel resultPlaty = bloodTestFrame.getLabel("", 20, shiftYValue(), 120, 70);
            bloodTestFrame.add(resultPlaty);
            resultPlaty.setText("Platelet Counts: ");

            JLabel resultPlatyVal = bloodTestFrame.getLabel("", 120, yValue, 270, 70);
            bloodTestFrame.add(resultPlatyVal);
            resultPlatyVal.setText(platyTB.getText() + "   [150 - 400]");

            JLabel resultHaemoglobin = bloodTestFrame.getLabel("", 20, shiftYValue(), 120, 70);
            bloodTestFrame.add(resultHaemoglobin);
            resultHaemoglobin.setText("Haemoglobin: ");

            JLabel resultHaemoglobinVal = bloodTestFrame.getLabel("", 120, yValue, 270, 70);
            bloodTestFrame.add(resultHaemoglobinVal);
            resultHaemoglobinVal.setText(haemoglobinTB.getText()  + "   [13.5 - 17.5]");

            JLabel resultLymphocytes = bloodTestFrame.getLabel("", 20, shiftYValue(), 120, 70);
            bloodTestFrame.add(resultLymphocytes);
            resultLymphocytes.setText("Lymphocytes: ");

            JLabel resultLymphocytesVal = bloodTestFrame.getLabel("", 120, yValue, 270, 70);
            bloodTestFrame.add(resultLymphocytesVal);
            resultLymphocytesVal.setText(lymphocytesTB.getText()  + "   [20 - 40]");

            JLabel result = bloodTestFrame.getLabel("", 20, shiftYValue(), 120, 70);
            bloodTestFrame.add(result);
            result.setText("Result: ");

            JLabel resultVal = bloodTestFrame.getLabel("", 120, yValue, 270, 70);
            bloodTestFrame.add(resultVal);
            resultVal.setText(bloodController.checkBloodCondition(platyTB.getText(), haemoglobinTB.getText(), lymphocytesTB.getText()));


        });



    }
    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }

}
