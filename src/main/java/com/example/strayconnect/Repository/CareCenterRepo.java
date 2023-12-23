package com.example.strayconnect.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.strayconnect.Model.CareCenter;

public interface CareCenterRepo extends JpaRepository<CareCenter,Integer>{
    
}
