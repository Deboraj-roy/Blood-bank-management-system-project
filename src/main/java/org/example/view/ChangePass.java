package org.example.view;

import org.example.controller.DonorController;
import org.example.model.entities.User;
import org.example.view.utilities.Frame;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

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

        backButton.addActionListener(e -> {

            changePassFrame.dispose();
            new Profile(user);
        });

        submitButton.addActionListener(e -> {

            DonorController donorController = new DonorController();

            String oldPass1 = oldPassTB.getText();
            String password1 = passwordTB.getText();
            String cpassword1 = cpasswordTB.getText();

            System.out.println(user.getPassword() + " " + oldPass1 +  " " + password1 + " " + cpassword1);

            if(!(user.getPassword().equals(oldPass1))) {
                System.out.println("Change pass Error");
            }
            else {

                if (password1.equals(cpassword1)){
                    System.out.println(cpassword1 + " " + password1);

                    new Login();


                    JFrame jFrame = new JFrame("Change Pass");
                    jFrame.setSize(200, 100);
                    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    jFrame.setVisible(true);
                    LayoutManager layoutManager = new FlowLayout(FlowLayout.LEFT, 0, 20);
                    jFrame.setLayout(layoutManager);


                    final JLabel jLabel = new JLabel("\n \n \n   Change Pass successfully!    \n \n \n");
                    jFrame.add(jLabel);


                    donorController.updatePass(user.getUserName(), password1);
                    changePassFrame.dispose();
                    new Login();

                }
                else {


                    JFrame jFrame = new JFrame("Change Pass");
                    jFrame.setSize(200, 100);
                    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    jFrame.setVisible(true);
                    LayoutManager layoutManager = new FlowLayout(FlowLayout.LEFT, 0, 20);
                    jFrame.setLayout(layoutManager);


                    final JLabel jLabel = new JLabel("\n \n \n   Change Pass Failed!    \n \n \n");
                    jFrame.add(jLabel);

                }


            }


        });
    }
    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }
}
