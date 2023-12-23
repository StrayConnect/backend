package com.example.strayconnect.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.strayconnect.Model.Breed;
import com.example.strayconnect.Service.BreedService;

import org.springframework.web.bind.annotation.RequestMapping;

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

@RestController
@RequestMapping("/breed")
@CrossOrigin("*")
public class BreedController {
    private BreedService breedService;
    public BreedController (BreedService breedService)
    {
        this.breedService = breedService;
    }
    
    @PostMapping("/add")
    public  String add(@RequestBody Map<String,String> breed){
        return breedService.add(breed);
    }

    @GetMapping("/get")
    public List<Breed> listBreed()
    {
        return breedService.getAll();
    }
    @GetMapping("/get/{id}")
    public Optional<Breed> get(@PathVariable("id") int id)
    {
        return breedService.get(id);
    }
    @PutMapping("/put")
    public String update(@RequestBody Map<String,String> breed)
    {
        return breedService.update(breed);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        return breedService.deleteById(id);
    }

}
