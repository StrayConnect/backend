package com.example.strayconnect.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.strayconnect.Model.User;

public interface UserRepo extends JpaRepository<User,Integer>{
    
}
