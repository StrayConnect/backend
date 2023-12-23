package com.example.strayconnect.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.strayconnect.Model.Breed;

public interface BreedService {
    // adding data
    String add(Map<String, String> breed);

    //get by id
    Optional<Breed> get(int id);

    // get all users
    List<Breed> getAll();

    
    // update user by id
    String update(Map<String, String> breed);

    // delete by id
    String deleteById(int id);
    
} 