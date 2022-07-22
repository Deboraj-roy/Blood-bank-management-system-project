package org.example.domain;

public class User {
 

    private String name;
    private String email;
    private String nid;
    private String birthdate;
    private String bloodgroup;
    private String phone;
    private String address;
    private String usertype;
    private String gender;
    private String password;


    public User() {}

    /*public User( String name, String email, String nid, String birthdate, String bloodgroup, String phone, String address, String usertype, String gender, String password) {
        this.nid = nid;
        this.email = email;
    }*/

    public User(String name, String email, String nid, String birthdate, String bloodgroup, String phone, String address, String usertype, String gender, String password) {
        this.name = name;
        this.email = email;
        this.nid = nid;
        this.birthdate = birthdate;
        this.bloodgroup = bloodgroup;
        this.phone = phone;
        this.address = address;
        this.usertype = usertype;
        this.gender = gender;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
