package org.example.view;

import org.example.controller.BloodController;
import org.example.model.entities.Blood;
import org.example.model.entities.User;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class BloodSearch extends JFrame {

    private int yValue = 20;

    private JTable jTable;

    private JTextField bloodIdTB;
    private static final int boxHeight = 30;
    private static final int boxWidth = 200;
    private String[] cols = {"blood_id", "donor_id", "plateletcount", "haemoglobin", "lymphocytes"};

    public BloodSearch(User user) {

        setSize(600, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Container container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.WHITE);
        BloodController bloodController = new BloodController();
        List<Blood> bloods =  bloodController.getAllBlood();

        for (int i = 0; i < bloods.size(); i++) {
            System.out.println(bloods.get(i).getBloodId() + " " + bloods.get(i).getDonorId() + " " +
                    bloods.get(i).getPlatelet() + " " + bloods.get(i).getHaemoglobin() + " " + bloods.get(i).getLymphocytes() + " " );
        }

        String[][] arr = new String[bloods.size()][5];

        for(int i = 0; i < bloods.size(); i++) {
            Blood blood = bloods.get(i);
            arr[i][0] = (String.valueOf(blood.getBloodId()));
            arr[i][1] =(String.valueOf(blood.getDonorId()));
            arr[i][2] =(String.valueOf(blood.getPlatelet()));
            arr[i][3] =(String.valueOf(blood.getHaemoglobin()));
            arr[i][4] =(String.valueOf(blood.getLymphocytes()));
        }

        jTable = new JTable(arr, cols);
        JScrollPane scroll = new JScrollPane(jTable);
        scroll.setBounds(50, 80, 600, 150);
        container.add(scroll);

        JLabel bloodId = new JLabel("ID: ");
        bloodId.setBounds(50, yValue + 200, 70, 70);
        add(bloodId);

        JButton submitButton = new JButton("Update");
        submitButton.setBounds(140, yValue + 200, boxWidth, boxHeight);
        add(submitButton);

        bloodIdTB = new JTextField();
        bloodIdTB.setBounds( 120, yValue + 20 + 200, boxWidth, boxHeight);
        add(bloodIdTB);

        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myTableMouseClicked(evt);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new BloodReceived(user, bloodIdTB.getText());
            }
        });


    }

    private void myTableMouseClicked(java.awt.event.MouseEvent evt) {
        int row = this.jTable.getSelectedRow();
        TableModel model = jTable.getModel();
        int val = Integer.parseInt(model.getValueAt(row,0).toString());
        System.out.println(val);
        bloodIdTB.setText(String.valueOf(val));

    }

    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }



}
