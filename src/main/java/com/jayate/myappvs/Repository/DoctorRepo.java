package com.jayate.myappvs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayate.myappvs.Model.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor,Integer>{
    
}
