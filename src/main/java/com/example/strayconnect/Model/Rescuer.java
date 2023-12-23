package com.example.strayconnect.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Rescuer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rescId;
    private String email;
    private String fname;
    private String lname;
    private long phone;
    private String street;
    @ManyToOne
    private City city;
    @ManyToOne
    private CareCenter center;
    
    @Override
    public String toString() {
        return "rescuer [rescId=" + rescId + ", email=" + email + ", fname=" + fname + ", lname=" + lname + ", phone="
                + phone + ", street=" + street + ", city=" + city + ", center=" + center + "]";
    }
    public Rescuer() {
    }
    public Rescuer( int rescId,String email, String fname, String lname, long phone, String street, City city,
            CareCenter center) {
        this.rescId = rescId;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.center = center;
    }
    public Rescuer( String email, String fname, String lname, long phone, String street, City city,
            CareCenter center) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.center = center;
    }
    public int getRescId() {
        return rescId;
    }
    public void setRescId(int rescId) {
        this.rescId = rescId;
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
    public CareCenter getCenter() {
        return center;
    }
    public void setCenter(CareCenter center) {
        this.center = center;
    }


 }
