package com.jayate.myappvs.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// import java.util.ArrayList;
// import java.util.List;

// import jakarta.persistence.OneToMany;


@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;
    private String city;

    // @OneToMany(mappedBy = "city")
    // private List<User> users = new ArrayList<>();
    
    
    @Override
    public String toString() {
        return "city [cityId=" + cityId + ", city=" + city + "]";
    }
    public City(int cityId, String city) {
        this.cityId = cityId;
        this.city = city;
    }
    public City() {
    }
    public int getCityId() {
        return cityId;
    }
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    
}
