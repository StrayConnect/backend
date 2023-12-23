package com.example.strayconnect.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.strayconnect.Model.User;
import com.example.strayconnect.Service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
        System.out.println("inside controller");
    }
     

    @PostMapping("/add")
    public  String add(@RequestBody Map<String,String> user){
        return userService.add(user);
    }

    @GetMapping("/get")
    public List<User> listUser()
    {
        return userService.getAllUser();
    }
    @GetMapping("/get/{id}")
    public Optional<User> get(@PathVariable("id") int id)
    {
        return userService.get(id);
    }
    @PutMapping("/put")
    public String updateUser(@RequestBody Map<String,String> user)
    {
        return userService.updateUser(user);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        return userService.deleteById(id);
    }

}
