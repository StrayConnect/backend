package com.example.strayconnect.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.strayconnect.Model.Animal;

public interface AnimalService {

        // adding data
    String add(Map<String, String> animal);

    //get by id
    Optional<Animal> get(int id);

    // get all users
    List<Animal> getAll();

    
    // update user by id
    String update(Map<String, String> animal);

    // delete by id
    String deleteById(int id);
}