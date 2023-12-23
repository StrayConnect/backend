package com.example.strayconnect.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.strayconnect.Model.AnimalCategory;

public interface AnimalCategoryRepo extends JpaRepository<AnimalCategory,Integer>{
    AnimalCategory findByAnimalType(String animalType);
}
