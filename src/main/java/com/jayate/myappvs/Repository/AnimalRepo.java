package com.jayate.myappvs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayate.myappvs.Model.Animal;

public interface AnimalRepo extends JpaRepository<Animal,Integer>{
    
}
