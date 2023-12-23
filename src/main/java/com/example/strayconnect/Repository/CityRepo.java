package com.example.strayconnect.Repository;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.strayconnect.Model.City;

public interface CityRepo extends JpaRepository<City,Integer>{
    City findByCity(String city);
}
