package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class welcome extends JFrame {


    private int yValue = 20;
    private static final int boxHeight = 30;
    private static final int boxWidth = 200;

    public welcome() {

        final Frame WELCOMEFrame = new Frame();
        JLabel WELCOME1 =  WELCOMEFrame.getLabel("        WELCOME TO BLOOD BANK", 200, yValue, 700, 70);
        WELCOMEFrame.add(WELCOME1);


        JButton loginButton =  WELCOMEFrame.getButton( "Login" ,300,yValue + 200, boxWidth, boxHeight);
        WELCOMEFrame.add(loginButton);

        JButton registrationButton =  WELCOMEFrame.getButton( "Registration" ,10,yValue + 200, boxWidth, boxHeight);
        WELCOMEFrame.add(registrationButton);


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                WELCOMEFrame.dispose();
                new Login();
            }
        });
        registrationButton.addActionListener(new ActionListener() {
            private ActionEvent e;

            @Override
            public void actionPerformed(ActionEvent e) {
                this.e = e;
                WELCOMEFrame.dispose();
                new Reg();
            }
        });


    }
}