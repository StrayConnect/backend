package com.example.strayconnect.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String email;
    private String fname;
    private String lname;
    private long phone;
    private String street;
    private String password;
    @ManyToOne
    private City city;

    public User() {
    }
    public User(String email, String fname, String lname, long phone, String street, City city, String password) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.password = password;
    }
    public User(int userId,String email, String fname, String lname, long phone, String street, City city) {
        this.userId = userId;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.street = street;
        this.city = city;
    }
    @Override
    public String toString() {
        return "user [userId=" + userId + ", email=" + email + ", fname=" + fname + ", lname=" + lname + ", phone="
                + phone + ", street=" + street + ", city=" + city + "]";
    }
    
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public long getPhone() {
        return phone;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }

    
}
