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

import com.example.strayconnect.Model.Rescuer;
import com.example.strayconnect.Service.RescuerService;

@RestController
@RequestMapping("/rescuer")
@CrossOrigin("*")
public class RescuerController {
    private RescuerService rescuerService;
    public RescuerController(RescuerService rescuerService)
    {
        this.rescuerService = rescuerService;
    } 
    

    @PostMapping("/add")
    public  String add(@RequestBody Map<String,String> rescuer){
        return rescuerService.add(rescuer);
    }

    @GetMapping("/get")
    public List<Rescuer> listUser()
    {
        return rescuerService.getAll();
    }
    @GetMapping("/get/{id}")
    public Optional<Rescuer> get(@PathVariable("id") int id)
    {
        return rescuerService.get(id);
    }
    @PutMapping("/put")
    public String updateRescuer(@RequestBody Map<String,String> rescuer)
    {
        return rescuerService.update(rescuer);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        return rescuerService.deleteById(id);
    }
}
