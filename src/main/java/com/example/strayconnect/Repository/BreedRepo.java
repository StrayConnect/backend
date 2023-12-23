package com.example.strayconnect.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.strayconnect.Model.Breed;

public interface BreedRepo extends JpaRepository<Breed,Integer>{
    
}
