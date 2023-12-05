package com.jayate.myappvs.Model;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalId;
    private String nickname;
    private String street;
    @ManyToOne
    private City cityId;
    @ManyToOne
    private Doctor docId;
    private Date lastCheckDate;
    private String healthDescription;
    private String healthStatus;
    @ManyToOne
    private Breed breedId;
    @ManyToOne
    private CareCenter center;
    
    public Animal(int animalId, String nickname, String street, City cityId, Doctor docId, Date lastCheckDate,
            String healthDescription, String healthStatus, Breed breedId, CareCenter center) {
        this.animalId = animalId;
        this.nickname = nickname;
        this.street = street;
        this.cityId = cityId;
        this.docId = docId;
        this.lastCheckDate = lastCheckDate;
        this.healthDescription = healthDescription;
        this.healthStatus = healthStatus;
        this.breedId = breedId;
        this.center = center;
    }
    @Override
    public String toString() {
        return "animal [animalId=" + animalId + ", nickname=" + nickname + ", street=" + street + ", cityId=" + cityId
                + ", docId=" + docId + ", lastCheckDate=" + lastCheckDate + ", healthDescription=" + healthDescription
                + ", healthStatus=" + healthStatus + ", breedId=" + breedId + ", center=" + center + "]";
    }
    public Animal() {
    }
    public int getAnimalId() {
        return animalId;
    }
    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public City getCityId() {
        return cityId;
    }
    public void setCityId(City cityId) {
        this.cityId = cityId;
    }
    public Doctor getDocId() {
        return docId;
    }
    public void setDocId(Doctor docId) {
        this.docId = docId;
    }
    public Date getLastCheckDate() {
        return lastCheckDate;
    }
    public void setLastCheckDate(Date lastCheckDate) {
        this.lastCheckDate = lastCheckDate;
    }
    public String getHealthDescription() {
        return healthDescription;
    }
    public void setHealthDescription(String healthDescription) {
        this.healthDescription = healthDescription;
    }
    public String getHealthStatus() {
        return healthStatus;
    }
    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }
    public Breed getBreedId() {
        return breedId;
    }
    public void setBreedId(Breed breedId) {
        this.breedId = breedId;
    }
    public CareCenter getCenter() {
        return center;
    }
    public void setCenter(CareCenter center) {
        this.center = center;
    }
    
    
}
