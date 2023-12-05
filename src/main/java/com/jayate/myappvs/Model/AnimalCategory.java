package com.jayate.myappvs.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AnimalCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalCategoryId;
    private String animalType;
    
    public int getAnimalCategoryId() {
        return animalCategoryId;
    }
    public void setAnimalCategoryId(int animalCategoryId) {
        this.animalCategoryId = animalCategoryId;
    }
    public String getAnimalType() {
        return animalType;
    }
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
    public AnimalCategory() {
    }
    public AnimalCategory(int animalCategoryId, String animalType) {
        this.animalCategoryId = animalCategoryId;
        this.animalType = animalType;
    }
    @Override
    public String toString() {
        return "animalCategory [animalCategoryId=" + animalCategoryId + ", animalType=" + animalType + "]";
    }

    
}
