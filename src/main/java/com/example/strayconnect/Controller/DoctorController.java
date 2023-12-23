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

import com.example.strayconnect.Model.Doctor;
import com.example.strayconnect.Service.DoctorService;

@RestController
@RequestMapping("/doctor")
@CrossOrigin("*")
public class DoctorController {
    private DoctorService doctorService;
    public DoctorController(DoctorService doctorService){
        this.doctorService = doctorService;
        System.out.println("controller of doctor initializaton works");
    }

    @PostMapping("/add")
    public  String add(@RequestBody Map<String,String> doctor){
        return doctorService.add(doctor);
    }

    @GetMapping("/get")
    public List<Doctor> listDoctor()
    {
        return doctorService.getAll();
    }
    @GetMapping("/get/{id}")
    public Optional<Doctor> get(@PathVariable("id") int id)
    {
        return doctorService.get(id);
    }
    @PutMapping("/put")
    public String updateDoctor(@RequestBody Map<String, String> doctor)
    {
        return doctorService.update(doctor);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        return doctorService.deleteById(id);
    }
}
