package com.jayate.myappvs.Controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jayate.myappvs.Model.User;
import com.jayate.myappvs.Service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // @PostMapping("/add")
    // public String add(@RequestBody User user, @RequestParam int cityId)
    // {
    //     System.out.println("link hit");
    //     return userService.add(user,cityId);
    // }
    @PostMapping("/add/{cityId}")
    public ResponseEntity<User> add(@RequestBody User user,@PathVariable("cityId") int cityId) {
    User addedUser = userService.add(user, cityId);
    return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public String listUser(Model model)
    {
        model.addAttribute("users",userService.getAllUser());
       return "users return successfully";
    }
    @GetMapping("/get/{id}")
    public Optional<User> get(@PathVariable("id") int id)
    {
        return userService.get(id);
    }
    @PutMapping("/put")
    public String updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        return userService.deleteById(id);
    }

}
