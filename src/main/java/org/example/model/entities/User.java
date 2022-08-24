package org.example.model.entities;

public class User {
  /*  private int userId= Integer.parseInt("");*/
    private String password;
    private String userName;
    private String email;
    private String phone;
    private String role;
    private String eligibility;
    private String age;
    private String bg;

    private String lastBlood;


    public User() {}

    public User(String username, String password, String role, String age, String email, String phone, String bg, String eligibility) {
        this.userName = username;
        this.password = password;
        this.role = role;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.bg = bg;
        this.eligibility = eligibility;

    }

    public User(String username, String age, String email, String phone, String bg) {
        this.userName = username;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.bg = bg;

    }

    public User(String age, String email, String phone, String bg) {

        this.age = age;
        this.phone = phone;
        this.email = email;
        this.bg = bg;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public int getUserId() {
        return userId;
    }*/
/*
    public void setUserId(int userId) {
        this.userId = userId;
    }*/

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public String getEligibility() {
        return eligibility;
    }

    public String getAge() {
        return age;
    }

    public String getBg() {
        return bg;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getLastBlood() {
        return lastBlood;
    }

    public void setLastBlood(String lastBlood) {
        this.lastBlood = lastBlood;
    }

}
