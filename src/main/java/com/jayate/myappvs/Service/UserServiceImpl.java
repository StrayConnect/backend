package com.jayate.myappvs.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jayate.myappvs.Model.City;
import com.jayate.myappvs.Model.User;
import com.jayate.myappvs.Repository.CityRepo;
import com.jayate.myappvs.Repository.UserRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;
    private CityRepo cityRepo;

    public UserServiceImpl(UserRepo userRepo,CityRepo cityRepo){
        this.cityRepo = cityRepo;
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUser() {
    return userRepo.findAll();
    }

    @Override
    public User add(User user,int cityId) {
         City city = cityRepo.findById(cityId)
                .orElseThrow(() -> new EntityNotFoundException("City with id " + cityId + " not found so firtstly add city"));
        user.setCity(city);
        return userRepo.save(user);
    }

    @Override
    public Optional<User> get(int id) {
        Optional<User> user = userRepo.findById(id);
        return user;
        
    }

    @Override
    public String updateUser(User user) {
        userRepo.save(user);
        return "update successfully";
    }

    @Override
    public String deleteById(int id) {
         userRepo.deleteById(id);
         return "delete successfully";
    }

}
