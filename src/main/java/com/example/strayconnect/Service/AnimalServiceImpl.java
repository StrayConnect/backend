package com.example.strayconnect.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.strayconnect.Model.CareCenter;
import com.example.strayconnect.Model.City;
import com.example.strayconnect.Model.Doctor;
import com.example.strayconnect.Model.Animal;
import com.example.strayconnect.Model.Breed;
import com.example.strayconnect.Repository.AnimalRepo;
import com.example.strayconnect.Repository.BreedRepo;
import com.example.strayconnect.Repository.CareCenterRepo;
import com.example.strayconnect.Repository.CityRepo;
import com.example.strayconnect.Repository.DoctorRepo;

@Service
class AnimalServiceImpl implements AnimalService{
    private AnimalRepo animalRepo;
    private CityRepo cityRepo;
    private CareCenterRepo careCenterRepo;
    private BreedRepo breedRepo;
    private DoctorRepo doctorRepo;


    public AnimalServiceImpl(AnimalRepo animalRepo, CityRepo cityRepo, CareCenterRepo careCenterRepo,BreedRepo breedRepo,DoctorRepo doctorRepo) {
        this.cityRepo = cityRepo;
        this.doctorRepo = doctorRepo;
        this.careCenterRepo = careCenterRepo;
        this.breedRepo = breedRepo;
        this.animalRepo = animalRepo;
    }

    @Override
    public String add(Map<String, String> animal) {
// int animalId, String nickname, String street, City cityId, Doctor docId, Date lastCheckDate,
            // String healthDescription, String healthStatus, Breed breedId, CareCenter center
        String nickname = animal.get("nickname");
        String street = animal.get("street");
        String cityName = animal.get("city");
        int docId = Integer.parseInt(animal.get("docId"));
        String date = animal.get("lastCheckDate");
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        LocalDate date1 = LocalDate.parse(date, formatter);
        System.out.println("Parsed Date: " + date1);
        

        String healthDescription = animal.get("healthDescription");
        String healthStatus = animal.get("healthStatus");
        int breedId = Integer.parseInt(animal.get("breedId"));
        int centerId = Integer.parseInt(animal.get("center"));
        
        City city = cityRepo.findByCity(cityName);
        if (city == null) {
            System.out.println("city is not in database hence adding to database");
            City c = new City(cityName);
            cityRepo.save(c);
            city = c;
        }
        
        Optional<CareCenter> center = careCenterRepo.findById(centerId);
        Optional<Doctor> doctor = doctorRepo.findById(docId);
        Optional<Breed> breed = breedRepo.findById(breedId);
        if (center.isPresent()) 
        {
            CareCenter c1 = center.get();
            if(doctor.isPresent())
            {
                Doctor d1 = doctor.get();
                if(breed.isPresent())
                {
                    Breed b1 = breed.get();
                    Animal newAnimal = new Animal(nickname,street,city,d1,date1,healthDescription,healthStatus,b1,c1);
                    animalRepo.save(newAnimal);
                    return "animal saved successfully";
                }else
                {
                    return "breed not exist of that breed id";
                }
            }
            else
            {
                return "doctor not exist of that doctor id";
            }
        } else 
        {
            return "center not exist of that care center id hence enter correct carecenter id to add";
        }


    }

    @Override
    public List<Animal> getAll() {
        return animalRepo.findAll();
    }

    @Override
    public Optional<Animal> get(int id) {
        Optional<Animal> animal = animalRepo.findById(id);
        return animal;
    }

    @Override
    public String update(Map<String, String> animal) {
        int animalId = Integer.parseInt(animal.get("animalId"));
        if(animalRepo.findById(animalId).isPresent())
        {

        String nickname = animal.get("nickname");
        String street = animal.get("street");
        String cityName = animal.get("city");
        int docId = Integer.parseInt(animal.get("docId"));
        String date = animal.get("lastCheckDate");
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        LocalDate date1 = LocalDate.parse(date, formatter);
        System.out.println("Parsed Date: " + date1);
        

        String healthDescription = animal.get("healthDescription");
        String healthStatus = animal.get("healthStatus");
        int breedId = Integer.parseInt(animal.get("breedId"));
        int centerId = Integer.parseInt(animal.get("center"));
        
        City city = cityRepo.findByCity(cityName);
        if (city == null) {
            System.out.println("city is not in database hence adding to database");
            City c = new City(cityName);
            cityRepo.save(c);
            city = c;
        }
        
        Optional<CareCenter> center = careCenterRepo.findById(centerId);
        Optional<Doctor> doctor = doctorRepo.findById(docId);
        Optional<Breed> breed = breedRepo.findById(breedId);
        if (center.isPresent()) 
        {
            CareCenter c1 = center.get();
            if(doctor.isPresent())
            {
                Doctor d1 = doctor.get();
                if(breed.isPresent())
                {
                    Breed b1 = breed.get();
                    Animal newAnimal = new Animal(animalId,nickname,street,city,d1,date1,healthDescription,healthStatus,b1,c1);
                    animalRepo.save(newAnimal);
                    return "animal updated successfully";
                }else
                {
                    return "breed not exist of that breed id";
                }
            }
            else
            {
                return "doctor not exist of that doctor id";
            }
        } else 
        {
            return "center not exist of that care center id hence enter correct carecenter id to add";
        }
        
        }
        else{
            return "no animal exist for such animal id";
        }
        

    }

    @Override
    public String deleteById(int id) {
        animalRepo.deleteById(id);
        return "delete successfully";
    }

}
