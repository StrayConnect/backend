package com.jayate.myappvs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayate.myappvs.Model.Breed;

public interface BreedRepo extends JpaRepository<Breed,Integer>{
    
}
