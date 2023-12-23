package com.example.strayconnect.Service;

import com.example.strayconnect.Repository.BreedRepo;

import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.example.strayconnect.Model.AnimalCategory;
import com.example.strayconnect.Model.Breed;
import com.example.strayconnect.Repository.AnimalCategoryRepo;

@Service
public class BreedServiceImpl implements BreedService {
    private BreedRepo breedRepo;
    private AnimalCategoryRepo animalCategoryRepo;

    public BreedServiceImpl(BreedRepo breedRepo, AnimalCategoryRepo animalCategoryRepo) {
        this.animalCategoryRepo = animalCategoryRepo;
        this.breedRepo = breedRepo;
    }

    @Override
    public String add(Map<String, String> breed) {

        String breedName = breed.get("breed");
        String animalType = breed.get("animalType");
        AnimalCategory ac = animalCategoryRepo.findByAnimalType(animalType);
        if (ac == null) {
            System.out.println("animal category not found hence entering it into database");
            AnimalCategory obj = new AnimalCategory(animalType);
            animalCategoryRepo.save(obj);
            ac = obj;
        }
        Breed newBreed = new Breed(breedName, ac);
        breedRepo.save(newBreed);
        return "breed added successfully";
    }

    @Override
    public List<Breed> getAll() {
        return breedRepo.findAll();
    }

    @Override
    public Optional<Breed> get(int id) {
        Optional<Breed> breed = breedRepo.findById(id);
        return breed;
    }

    @Override
    public String update(Map<String, String> breed) {
        int breedId = Integer.parseInt(breed.get("breedId"));
        if (breedRepo.findById(breedId).isPresent()) {
            String breedName = breed.get("breed");
            String animalType = breed.get("animalType");
            AnimalCategory ac = animalCategoryRepo.findByAnimalType(animalType);
            if (ac == null) {
                System.out.println("animal category not found hence entering it into database");
                AnimalCategory obj = new AnimalCategory(animalType);
                animalCategoryRepo.save(obj);
                ac = obj;
            }
            Breed newBreed = new Breed(breedId,breedName, ac);
            breedRepo.save(newBreed);
            return "breed updated successfully";
        } else 
        {
            return "invalid breed id";
        }

    }

    @Override
    public String deleteById(int id) {
        breedRepo.deleteById(id);
        return "delete successfully";
    }

}
