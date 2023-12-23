package com.example.strayconnect.Service;

// import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.strayconnect.Model.City;
import com.example.strayconnect.Model.User;
import com.example.strayconnect.Repository.CityRepo;
import com.example.strayconnect.Repository.UserRepo;

// import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;
    private CityRepo cityRepo;

    public UserServiceImpl(UserRepo userRepo, CityRepo cityRepo) {
        this.cityRepo = cityRepo;
        this.userRepo = userRepo;
        System.out.println("inside service impl");
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public String add(Map<String, String> user) {

        String email = user.get("email");
        String fname = user.get("fname");
        String lname = user.get("lname");
        Long phone = Long.parseLong(user.get("phone"));
        String street = user.get("street");
        String cityName = user.get("city");
        String password = user.get("password");

        // finding city by city name
        City city = cityRepo.findByCity(cityName);
        // Optional<City> cityOptional = cityRepo.findByCity(cityName);

        // City city = cityOptional.orElse(null);

        if (city == null) {
            System.out.println("city is not in database hence adding to database");
            City c = new City(cityName);
            cityRepo.save(c);
            city = c;
        }

        User newUser = new User(email, fname, lname, phone, street, city, password);
        userRepo.save(newUser);
        return "user saved successfully";

        /*
         * try {
         * // Get the Class object of the unknown object
         * Class<?> objectClass = user.getClass();
         * 
         * // Get the Field object of the specified attribute
         * Field field = objectClass.getDeclaredField("city");
         * 
         * // Make the field accessible (even if it's private)
         * field.setAccessible(true);
         * 
         * // Get the value of the attribute from the object
         * String cityName = (String) field.get(user);
         * 
         * Optional<City> cityOptional = cityRepo.findByName(cityName);
         * 
         * City city = cityOptional.orElse(null);
         * 
         * if(city == null)
         * {
         * City c = new City(cityName);
         * cityRepo.save(c);
         * city = c;
         * }
         * 
         * 
         * //updating user object
         * field.set(user,city);
         * User newUser = (User) user;
         * 
         * 
         * // saving data of user
         * userRepo.save(newUser);
         * return "user saved successfully";
         * 
         * } catch (NoSuchFieldException | IllegalAccessException e) {
         * // Handle exceptions appropriately (e.g., log or rethrow)
         * e.printStackTrace();
         * return "error occured in saving user";
         * }
         * 
         */

        // City city = cityRepo.findBy(cityId)
        // .orElseThrow(() -> new EntityNotFoundException("City with id " + cityId + "
        // not found so firtstly add city"));

        // user.setCity(city);
        // return userRepo.save(user_data);

    }

    @Override
    public Optional<User> get(int id) {
        Optional<User> user = userRepo.findById(id);
        return user;
    }

    @Override
    public String updateUser(Map<String, String> user) {
        int userId = Integer.parseInt(user.get("userId"));

        // checking whether user exist of userId or not
        if (userRepo.findById(userId).isPresent()) {
            String email = user.get("email");
            String fname = user.get("fname");
            String lname = user.get("lname");
            Long phone = Long.parseLong(user.get("phone"));
            String street = user.get("street");
            String cityName = user.get("city");

            // finding city by city name
            City city = cityRepo.findByCity(cityName);
            // Optional<City> cityOptional = cityRepo.findByCity(cityName);

            // City city = cityOptional.orElse(null);

            if (city == null) {
                System.out.println("city is not in database hence adding to database");
                City c = new City(cityName);
                cityRepo.save(c);
                city = c;
            }

            User newUser = new User(userId, email, fname, lname, phone, street, city);
            userRepo.save(newUser);
            return "user update successfully";
        } else {
            return "user not exist for this userId";
        }

    }

    @Override
    public String deleteById(int id) {
        userRepo.deleteById(id);
        return "delete successfully";
    }

}