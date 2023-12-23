package com.example.strayconnect.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.strayconnect.Model.Animal;

public interface AnimalRepo extends JpaRepository<Animal,Integer>{
    
}
