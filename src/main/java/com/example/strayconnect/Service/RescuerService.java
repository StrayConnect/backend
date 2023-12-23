package com.example.strayconnect.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.strayconnect.Model.Rescuer;

public interface RescuerService {
    // adding data
    String add(Map<String, String> rescuer);

    //get by id
    Optional<Rescuer> get(int id);

    // get all users
    List<Rescuer> getAll();

    
    // update user by id
    String update(Map<String, String> rescuer);

    // delete by id
    String deleteById(int id);
    
}
