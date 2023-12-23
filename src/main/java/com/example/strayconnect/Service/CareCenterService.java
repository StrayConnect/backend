package com.example.strayconnect.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.strayconnect.Model.CareCenter;

public interface CareCenterService {
     // adding data
    String add(Map<String, String> careCenter);

    //get by id
    Optional<CareCenter> get(int id);

    // get all users
    List<CareCenter> getAll();

    
    // update user by id
    String update(Map<String, String> careCenter);

    // delete by id
    String deleteById(int id);
}
