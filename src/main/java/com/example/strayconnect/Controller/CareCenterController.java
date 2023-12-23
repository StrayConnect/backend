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

import com.example.strayconnect.Model.CareCenter;
import com.example.strayconnect.Service.CareCenterService;


@RestController
@RequestMapping("/careCenter")
@CrossOrigin("*")
public class CareCenterController {
     private CareCenterService careCenterService;
    public CareCenterController (CareCenterService careCenterService)
    {
        this.careCenterService = careCenterService;
    }
    
    @PostMapping("/add")
    public  String add(@RequestBody Map<String,String> careCenter){
        return careCenterService.add(careCenter);
    }

    @GetMapping("/get")
    public List<CareCenter> listCareCenter()
    {
        return careCenterService.getAll();
    }
    @GetMapping("/get/{id}")
    public Optional<CareCenter> get(@PathVariable("id") int id)
    {
        return careCenterService.get(id);
    }
    @PutMapping("/put")
    public String update(@RequestBody Map<String,String> careCenter)
    {
        return careCenterService.update(careCenter);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        return careCenterService.deleteById(id);
    }
}
