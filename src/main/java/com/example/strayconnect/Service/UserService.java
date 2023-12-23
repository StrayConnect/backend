package com.example.strayconnect.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.strayconnect.Model.User;

public interface UserService {
 

    // adding data
    String add(Map<String, String> user);

    //get by id
    Optional<User> get(int id);

    // get all users
    List<User> getAllUser();

    
    // update user by id
    String updateUser(Map<String,String> user);

    // delete by id
    String deleteById(int id);
    
}
     