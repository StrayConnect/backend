package com.example.strayconnect.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.strayconnect.Model.Doctor;

public interface DoctorService {
    // adding data
    String add(Map<String, String> doctor);

    //get by id
    Optional<Doctor> get(int id);

    // get all users
    List<Doctor> getAll();

    
    // update user by id
    String update(Map<String, String> doctor);

    // delete by id
    String deleteById(int id);
    
}
