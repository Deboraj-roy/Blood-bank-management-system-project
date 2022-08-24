package org.example.model.entities;

public class Blood {

    private int bloodId;
    private int donorId;
    private int platelet;
    private double haemoglobin;
    private int lymphocytes;
    private String condition;

    public Blood(int bloodId, int donorId, int platelet, double haemoglobin, int lymphocytes, String condition) {
        this.bloodId = bloodId;
        this.donorId = donorId;
        this.platelet = platelet;
        this.haemoglobin = haemoglobin;
        this.lymphocytes = lymphocytes;
        this.condition = condition;
    }

    public Blood(int donorId, int platelet, double haemoglobin, int lymphocytes) {
        this.donorId = donorId;
        this.platelet = platelet;
        this.haemoglobin = haemoglobin;
        this.lymphocytes = lymphocytes;
    }

    public Blood() {

    }

    public int getBloodId() {
        return bloodId;
    }

    public void setBloodId(int bloodId) {
        this.bloodId = bloodId;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public int getPlatelet() {
        return platelet;
    }

    public void setPlatelet(int platelet) {
        this.platelet = platelet;
    }

    public double getHaemoglobin() {
        return haemoglobin;
    }

    public void setHaemoglobin(double haemoglobin) {
        this.haemoglobin = haemoglobin;
    }

    public int getLymphocytes() {
        return lymphocytes;
    }

    public void setLymphocytes(int lymphocytes) {
        this.lymphocytes = lymphocytes;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
