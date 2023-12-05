package com.jayate.myappvs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayate.myappvs.Model.AnimalCategory;

public interface AnimalCategoryRepo extends JpaRepository<AnimalCategory,Integer>{
    
}
