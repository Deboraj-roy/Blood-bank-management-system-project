package org.example.view;

import org.example.controller.RegController;
import org.example.view.utilities.Frame;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Reg extends JFrame {
    private int yValue = 20;

    private static final String roleVal [] = {"Donor", "Patient"};

    private static final String bgVal [] = {"A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-", "AB-"};
    private static final int boxHeight = 30;
    private static final int boxWidth = 200;

    public Reg() {

        Frame regFrame = new Frame();

        JLabel username = regFrame.getLabel("Username", 20, yValue, 70, 70);
        regFrame.add(username);

        JTextField userTB = regFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        regFrame.add(userTB);

        JLabel password = regFrame.getLabel("Password: ", 20, shiftYValue(), 70, 70);
        regFrame.add(password);

        JTextField passwordTB = regFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        regFrame.add(passwordTB);

        JLabel cpassword = regFrame.getLabel("Confirm Password: ", 20, shiftYValue(), 70, 70);
        regFrame.add(cpassword);

        JTextField cpasswordTB = regFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        regFrame.add(cpasswordTB);

        JLabel age = regFrame.getLabel("Age: ", 20, shiftYValue(), 70, 70);
        regFrame.add(age);

        JTextField ageTB = regFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        regFrame.add(ageTB);

        JLabel role = regFrame.getLabel("Role: ", 20, shiftYValue(), 70, 70);
        regFrame.add(role);

        JComboBox roleTB = new JComboBox(roleVal);
        roleTB.setBounds(120, yValue + 20, boxWidth, boxHeight);
        regFrame.add(roleTB);

        JLabel email = regFrame.getLabel("Email: ", 20, shiftYValue(), 70, 70);
        regFrame.add(email);

        JTextField emailTB = regFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        regFrame.add(emailTB);

        JLabel phone = regFrame.getLabel("Phone: ", 20, shiftYValue(), 70, 70);
        regFrame.add(phone);

        JTextField phoneTB = regFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        regFrame.add(phoneTB);

        JLabel bloodgroup = regFrame.getLabel("Blood Group: ", 20, shiftYValue(), 100, 70);
        regFrame.add(bloodgroup);

        JComboBox bloodTB = new JComboBox(bgVal);
        bloodTB.setBounds(120, yValue + 20, boxWidth, boxHeight);
        regFrame.add(bloodTB);

        JButton submitButton = regFrame.getButton("Submit", 140, yValue + 200, boxWidth, boxHeight);
        regFrame.add(submitButton);

        JButton backButton = regFrame.getButton("Back", 140, yValue + 300, boxWidth, boxHeight);
        regFrame.add(backButton);

        backButton.addActionListener(e -> {

            regFrame.dispose();
            new Login();
        });

        submitButton.addActionListener(e -> {

            RegController regController = new RegController();



            if (passwordTB.getText().equals(cpasswordTB.getText())){
                System.out.println(roleTB.getSelectedItem() + " " + bloodTB.getSelectedItem());

                regController.insertUser(userTB.getText(), passwordTB.getText(), Objects.requireNonNull(roleTB.getSelectedItem()).toString(),
                        ageTB.getText(), emailTB.getText(), phoneTB.getText(), Objects.requireNonNull(bloodTB.getSelectedItem()).toString(), "YES");
                regFrame.dispose();
                new Login();


                JFrame jFrame = new JFrame("Register");
                jFrame.setSize(200, 100);
                jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jFrame.setVisible(true);
                LayoutManager layoutManager = new FlowLayout(FlowLayout.LEFT, 0, 20);
                jFrame.setLayout(layoutManager);


                final JLabel jLabel = new JLabel("\n \n \n   Registration successfully!    \n \n \n");
                jFrame.add(jLabel);

                regFrame.dispose();
                //jFrame.dispose();
                new Login();

            }
            else {


                JFrame jFrame = new JFrame("Register");
                jFrame.setSize(200, 100);
                jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                jFrame.setVisible(true);
                LayoutManager layoutManager = new FlowLayout(FlowLayout.LEFT, 0, 20);
                jFrame.setLayout(layoutManager);


                final JLabel jLabel = new JLabel("\n \n \n   Registration Failed!    \n \n \n");
                jFrame.add(jLabel);

            }




        });



    }
    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }

}
