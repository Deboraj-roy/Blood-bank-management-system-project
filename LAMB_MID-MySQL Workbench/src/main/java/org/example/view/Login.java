package org.example.view;

import org.example.controller.LoginController;
import org.example.model.entities.User;
import org.example.view.utilities.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Login extends JFrame {

    private int yValue = 20;
    private static final int boxHeight  = 30;
    private static final int boxWidth  = 200;

    public Login() {
        Frame loginFrame = new Frame();
        JLabel username =  loginFrame.getLabel("Username", 20, yValue, 70, 70);
        loginFrame.add(username);


        JTextField userTB =  loginFrame.getTextField( 120, yValue + 20, boxWidth, boxHeight);
        loginFrame.add(userTB);

        JLabel password =  loginFrame.getLabel("Password: ", 20, shiftYValue(), 70, 70);
        loginFrame.add(password);

        JTextField passwordTB =  loginFrame.getTextField( 120,yValue + 20, boxWidth, boxHeight);
        loginFrame.add(passwordTB);

        JButton loginButton =  loginFrame.getButton( "Login" ,140,yValue + 100, boxWidth, boxHeight);
        loginFrame.add(loginButton);

        JButton registrationButton =  loginFrame.getButton( "New Registration" ,140,yValue + 300, boxWidth, boxHeight);
        loginFrame.add(registrationButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LoginController loginController = new LoginController();

                String username = userTB.getText();
                String password = passwordTB.getText();

                int userId = loginController.authorizeUser(username, password).getUserId();
                loginFrame.dispose();
                User user = loginController.getUserById(userId);
                user.setUserId(userId);
                System.out.println(user.getRole());
                if(user.getRole().equals("Donor"))
                    new DonorDash(user);
                else
                    new PatientDash(user);

            }
        });

        registrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                loginFrame.dispose();
                new Reg();
            }
        });
    }

    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }
}
