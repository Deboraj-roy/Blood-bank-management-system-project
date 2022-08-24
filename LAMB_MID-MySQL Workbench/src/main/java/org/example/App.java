package org.example;


import org.example.view.Login;

import javax.swing.*;

public class App
{
    public static void main( String[] args ) {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();

            }
        });

    }
}
