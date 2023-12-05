package com.jayate.myappvs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayate.myappvs.Model.City;

public interface CityRepo extends JpaRepository<City,Integer>{
    
}
