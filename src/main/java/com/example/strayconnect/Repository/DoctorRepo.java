package com.example.strayconnect.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.strayconnect.Model.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor,Integer>{
    
}
