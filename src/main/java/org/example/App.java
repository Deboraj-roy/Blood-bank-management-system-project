package org.example;


import org.example.view.Login;

import javax.swing.*;

public class App
{
    public static void main( String[] args ) {


        SwingUtilities.invokeLater(Login::new);

    }
}
