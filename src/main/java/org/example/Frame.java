package org.example;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {

        setSize(600, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Container container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);

    }

    public JLabel getLabel(String title, int x, int y, int width, int height) {
        final JLabel jLabel = new JLabel(title);
        jLabel.setBounds(x, y, width, height);
        return jLabel;
    }

    public JTextField getTextField(int x, int y, int width, int height) {
        final JTextField jTextField = new JTextField();
        jTextField.setBounds(x, y, width, height);
        return jTextField;
    }

    public JButton getButton(String title, int x, int y, int width, int height) {
        JButton button = new JButton(title);
        button.setBounds(x, y, width, height);
        return button;
    }
}
