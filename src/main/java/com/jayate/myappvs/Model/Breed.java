package com.jayate.myappvs.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Breed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int breedId;
    private String breed;
    @ManyToOne
    private AnimalCategory animalId;
    
    @Override
    public String toString() {
        return "breed [breedId=" + breedId + ", breed=" + breed + ", animalId=" + animalId + "]";
    }
    public Breed(int breedId, String breed, AnimalCategory animalId) {
        this.breedId = breedId;
        this.breed = breed;
        this.animalId = animalId;
    }
    public Breed() {
    }
    public int getBreedId() {
        return breedId;
    }
    public void setBreedId(int breedId) {
        this.breedId = breedId;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public AnimalCategory getAnimalId() {
        return animalId;
    }
    public void setAnimalId(AnimalCategory animalId) {
        this.animalId = animalId;
    }
    
}
