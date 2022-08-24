package org.example.view;

import org.example.controller.BloodController;
import org.example.controller.DonorController;
import org.example.model.entities.Blood;
import org.example.model.entities.User;
import org.example.view.utilities.Frame;

import javax.swing.*;

public class BloodReceived {

    private int yValue = 20;
    private static final int boxHeight = 30;
    private static final int boxWidth = 200;

    public BloodReceived(User user, String bloodId) {

        Frame bloodReceivedFrame = new Frame();
        JLabel message = bloodReceivedFrame.getLabel("Blood Donation Completed", 20, yValue, 70, 70);
        bloodReceivedFrame.add(message);

        BloodController bloodController = new BloodController();
        DonorController donorController = new DonorController();
        Blood blood = bloodController.getBlood(bloodId);
        User donorObj = donorController.getUserByName(blood.getDonorId());


        JLabel donor = bloodReceivedFrame.getLabel("Donated By: "+ donorObj.getUserName(), 20, shiftYValue(), 470, 70);
        bloodReceivedFrame.add(donor);

        JLabel receiver = bloodReceivedFrame.getLabel("Donated By: "+ user.getUserName(), 20, shiftYValue(), 470, 70);
        bloodReceivedFrame.add(receiver);

    }

    public int shiftYValue() {
        yValue = yValue + 40;
        return yValue;
    }

}
