package org.example;

import org.example.dao.UserDao;
import org.example.domain.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProfile extends JFrame {
    private int yValue = 20;

    protected String pass,cPass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    private static final String roleVal [] = {"Donor", "Client"};

    private static final String bgVal [] = {"A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};
    private static final int boxHeight = 30;
    private static final int boxWidth = 300;

    public EditProfile(User user) {

        final Frame regFrame = new Frame();

        JLabel name = regFrame.getLabel("Name: ", 20, shiftYValue(), 70, 70);
        regFrame.add(name);

        final JTextField nameTB = regFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        regFrame.add(nameTB);

        JLabel nid = regFrame.getLabel("NID:", 20, shiftYValue(), 70, 70);
        regFrame.add(nid);

        final JTextField nidTB = regFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        regFrame.add(nidTB);

        JLabel phone = regFrame.getLabel("Phone: ", 20, shiftYValue(), 70, 70);
        regFrame.add(phone);

        final JTextField phoneTB = regFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        regFrame.add(phoneTB);

        JLabel address = regFrame.getLabel("Address: ", 20, shiftYValue(), 70, 70);
        regFrame.add(address);

        final JTextField addressTB = regFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        regFrame.add(addressTB);


        final JLabel password = regFrame.getLabel("Password: ", 20, shiftYValue(), 70, 70);
        regFrame.add(password);

        final JTextField passwordTB = regFrame.getTextField(120, yValue + 20, boxWidth, boxHeight);
        regFrame.add(passwordTB);

        JButton submitButton = regFrame.getButton("Update", 1,600, 100, boxHeight);
        regFrame.add(submitButton);

        JButton backButton = regFrame.getButton("Back", 100,600, 100, boxHeight);
        regFrame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                switch (user.getUsertype()) {
                    case "Admin":

                        regFrame.dispose();
                        new AdminProfile(user);

                        break;
                    case "Donner":

                        regFrame.dispose();
                        new DonnerProfile(user);

                        break;
                    default:

                        regFrame.dispose();
                        new ClientProfile(user);
                        break;
                }

            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                User user = new User();
                user.setName(nameTB.getText());
                user.setNid(nidTB.getText());
                user.setPhone(phoneTB.getText());
                user.setAddress(addressTB.getText());
                user.setPassword(passwordTB.getText());
                String email = user.getEmail();
                user.setEmail(email);
                UserDao.updateUser(user);

                regFrame.dispose();
                User updateUser = UserDao.validationByEmail(user.getEmail());
                updateUser.setEmail(user.getEmail());
                //new Profile(updateUser);
                switch (updateUser.getUsertype()) {
                    case "Admin":

                        regFrame.dispose();
                        new AdminProfile(user);

                        break;
                    case "Donner":

                        regFrame.dispose();
                        new DonnerProfile(user);

                        break;
                    default:

                        regFrame.dispose();
                        new ClientProfile(user);
                        break;
                }


/*
                if (passwordTB.getText().equals(cpasswordTB.getText())){

                    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
                    UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
                    // userDao.create(new User("DEB", "deb2@aiub.edu", "11111111111111", "01-Jun-98", "AB-", "01900000000", "Chittagong", "Donner", "Male", "123"));
                    userDao.create(new User(nameTB.getText(), emailTB.getText(), nidTB.getText(), birthdateTB.getText(), bloodTB.getSelectedItem().toString(), phoneTB.getText(), addressTB.getText(), userTB.getSelectedItem().toString(), genderTB.getText(), passwordTB.getText()));



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

                }*/

            }
        });

/*
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                regFrame.dispose();
                new Login();

            }
        });*/


    }
    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }

}
