package org.example.view;

import org.example.controller.LoginController;
import org.example.model.entities.User;
import org.example.view.utilities.Frame;

import javax.swing.*;

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

        loginButton.addActionListener(e -> {

            LoginController loginController = new LoginController();

            String username1 = userTB.getText();
            String password1 = passwordTB.getText();

            //int userId = loginController.authorizeUser(username, password).getUserId();
            //String userName = loginController.authorizeUser(username, password).getUserId();
            //String username2 = String.valueOf(loginController.authorizeUser(username1, password1));
           // ** String username2 =  loginController.authorizeUser(username1, password1).getUserName();
            String username2 = loginController.authorizeUser(username1, password1);
            loginFrame.dispose();
            User user = loginController.getUserByName(username2);
            user.setUserName(username2);
            System.out.println(user.getRole());
            if(user.getRole().equals("Donor"))
                new DonorDash(user);
            else
                new PatientDash(user);

        });

        registrationButton.addActionListener(e -> {

            loginFrame.dispose();
            new Reg();
        });
    }

    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }
}
