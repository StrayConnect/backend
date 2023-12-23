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

import com.example.strayconnect.Model.Animal;
import com.example.strayconnect.Service.AnimalService;

@RestController
@RequestMapping("/animal")
@CrossOrigin("*")
public class AnimalController {
    private AnimalService animalService;
    public AnimalController(AnimalService animalService)
    {
        this.animalService = animalService;
    } 

    //while writing json give "city":"cityname"           //dont write "cityId":"cityname"
    @PostMapping("/add")
    public  String add(@RequestBody Map<String,String> animal){
        return animalService.add(animal);
    }

    @GetMapping("/get")
    public List<Animal> listUser()
    {
        return animalService.getAll();
    }
    @GetMapping("/get/{id}")
    public Optional<Animal> get(@PathVariable("id") int id)
    {
        return animalService.get(id);
    }
    @PutMapping("/put")
    public String updateAnimal(@RequestBody Map<String,String> animal)
    {
        return animalService.update(animal);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        return animalService.deleteById(id);
    }
}
