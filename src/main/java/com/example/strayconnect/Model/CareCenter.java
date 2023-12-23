package com.example.strayconnect.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CareCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int centerId;
    private String street;
    @ManyToOne
    private City city;
    private long phone;

    public int getCenterId() {
        return centerId;
    }
    public void setCenterId(int centerId) {
        this.centerId = centerId;
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
    public long getPhone() {
        return phone;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }
    public CareCenter() {
    }
    public CareCenter( int centerId,String street, City city, long phone) {
        this.centerId = centerId;
        this.street = street;
        this.city = city;
        this.phone = phone;
    }
    public CareCenter( String street, City city, long phone) {
        this.street = street;
        this.city = city;
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "careCenter [centerId=" + centerId + ", street=" + street + ", city=" + city + ", phone=" + phone + "]";
    }
    
    
}
