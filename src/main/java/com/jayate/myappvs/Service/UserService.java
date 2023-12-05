package com.jayate.myappvs.Service;
import java.util.List;
import java.util.Optional;

import com.jayate.myappvs.Model.User;

public interface UserService {


    // adding data
    User add(User user,int cityId);

    //get by id
    Optional<User> get(int id);

    // get all users
    List<User> getAllUser();

    
    // update user by id
    String updateUser(User user);

    // delete by id
    String deleteById(int id);
    
}
     