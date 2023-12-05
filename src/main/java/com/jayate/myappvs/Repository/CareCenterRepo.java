package com.jayate.myappvs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayate.myappvs.Model.CareCenter;

public interface CareCenterRepo extends JpaRepository<CareCenter,Integer>{
    
}
