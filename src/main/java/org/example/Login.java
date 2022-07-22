package org.example;

import org.example.domain.User;

import javax.swing.*;

public class Login extends JFrame {

    private int yValue = 20;
    private static final int boxHeight = 30;
    private static final int boxWidth = 200;

    public Login() {

        final Frame loginFrame = new Frame();
        JLabel email =  loginFrame.getLabel("Email:", 20, yValue, 70, 70);
        loginFrame.add(email);


        JTextField emailTB =  loginFrame.getTextField( 120, yValue + 20, boxWidth, boxHeight);
        loginFrame.add(emailTB);

        JLabel password =  loginFrame.getLabel("Password:", 20, shiftYValue(), 70, 70);
        loginFrame.add(password);

        JTextField passwordTB =  loginFrame.getTextField( 120,yValue + 20, boxWidth, boxHeight);
        loginFrame.add(passwordTB);

        JButton loginButton =  loginFrame.getButton( "Login" ,140,yValue + 100, boxWidth, boxHeight);
        loginFrame.add(loginButton);

        JButton registrationButton =  loginFrame.getButton( "Registration" ,140,yValue + 300, boxWidth, boxHeight);
        loginFrame.add(registrationButton);

        JButton homeButton =  loginFrame.getButton( "Home" ,140,yValue + 100, boxWidth, boxHeight);
        loginFrame.add(homeButton);

        homeButton.addActionListener(e -> {
            loginFrame.dispose();
            new welcome();

        });


        loginButton.addActionListener(e -> {




            LoginController loginController = new LoginController();

            String email2 = emailTB.getText();
            String password2 = passwordTB.getText();

            String userMail = loginController.validation(email2, password2).getEmail();
            loginFrame.dispose();
            User user = loginController.getUserByEmail(userMail);
            user.setEmail(userMail);
            //System.out.println(user.getUsertype());

                switch (user.getUsertype()) {
                    case "Admin":

                        loginFrame.dispose();
                        new AdminProfile(user);

                        break;
                    case "Donner":

                        loginFrame.dispose();
                        new DonnerProfile(user);

                        break;
                    default:

                        loginFrame.dispose();
                        new ClientProfile(user);
                        break;
                }


        });



        registrationButton.addActionListener(e -> {
            loginFrame.dispose();
            new Reg();

        });

    }

    public int shiftYValue () {
        yValue = yValue + 40;
        return yValue;

    }
}