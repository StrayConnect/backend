package com.jayate.myappvs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayate.myappvs.Model.User;

public interface UserRepo extends JpaRepository<User,Integer>{
    
}
