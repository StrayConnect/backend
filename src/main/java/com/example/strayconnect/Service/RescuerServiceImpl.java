package com.example.strayconnect.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.strayconnect.Model.CareCenter;
import com.example.strayconnect.Model.City;
import com.example.strayconnect.Model.Rescuer;
import com.example.strayconnect.Repository.CareCenterRepo;
import com.example.strayconnect.Repository.CityRepo;
import com.example.strayconnect.Repository.RescuerRepo;

@Service
public class RescuerServiceImpl implements RescuerService {

    private RescuerRepo rescuerRepo;
    private CityRepo cityRepo;
    private CareCenterRepo careCenterRepo;

    public RescuerServiceImpl(RescuerRepo rescuerRepo, CityRepo cityRepo, CareCenterRepo careCenterRepo) {
        this.cityRepo = cityRepo;
        this.rescuerRepo = rescuerRepo;
        this.careCenterRepo = careCenterRepo;
    }

    // int rescId,String email, String fname, String lname, long phone, String
    // street, City city,CareCenter center
    @Override
    public String add(Map<String, String> rescuer) {
        String email = rescuer.get("email");
        String fname = rescuer.get("fname");
        String lname = rescuer.get("lname");
        Long phone = Long.parseLong(rescuer.get("phone"));
        String street = rescuer.get("street");
        String cityName = rescuer.get("city");
        City city = cityRepo.findByCity(cityName);
        if (city == null) {
            System.out.println("city is not in database hence adding to database");
            City c = new City(cityName);
            cityRepo.save(c);
            city = c;
        }
        int centerId = Integer.parseInt(rescuer.get("center"));
        Optional<CareCenter> center = careCenterRepo.findById(centerId);
        if (center.isPresent()) {
            System.out.println("inside present");
            CareCenter c1 = center.get();
            Rescuer newRescuer = new Rescuer(email, fname, lname, phone, street, city, c1);
            rescuerRepo.save(newRescuer);
            return "rescuer added successfully";
        } else {
            System.out.println("inside else");
            return "center not exist of that care centerid hence enter correct carecenter id to add";
        }

    }

    @Override
    public List<Rescuer> getAll() {
        return rescuerRepo.findAll();
    }

    @Override
    public Optional<Rescuer> get(int id) {
        Optional<Rescuer> rescuer = rescuerRepo.findById(id);
        return rescuer;
    }

    // int rescId,String email, String fname, String lname, long phone, String
    // street, City city,CareCenter center
    @Override
    public String update(Map<String, String> rescuer) {
        int rescId = Integer.parseInt(rescuer.get("rescId"));
        // checking whether rescId exist or not if not then display message that rescId
        // not exist if i do not handel
        // that rescId exist or not then in case of rescId not exist if we update then
        // it will add data hence
        // its required to check whether person of that id exist or not whose i am going
        // to update

        if (rescuerRepo.findById(rescId).isPresent()) 
        {

            String email = rescuer.get("email");
            String fname = rescuer.get("fname");
            String lname = rescuer.get("lname");
            Long phone = Long.parseLong(rescuer.get("phone"));
            String street = rescuer.get("street");
            String cityName = rescuer.get("city");
            City city = cityRepo.findByCity(cityName);
            if (city == null) {
                System.out.println("city is not in database hence adding to database");
                City c = new City(cityName);
                cityRepo.save(c);
                city = c;
            }
            int centerId = Integer.parseInt(rescuer.get("center"));
            Optional<CareCenter> center = careCenterRepo.findById(centerId);
            if (center.isPresent()) {
                System.out.println("inside present");
                CareCenter c1 = center.get();
                Rescuer newRescuer = new Rescuer(rescId, email, fname, lname, phone, street, city, c1);
                rescuerRepo.save(newRescuer);
                return "rescuer updated successfully";
            } else {
                System.out.println("inside else");
                return "center not exist of that care center id so give correct care centerId to update";
            }
        } 
        else 
        {
            return "rescID entered by you not exist";
        }
    }

    @Override
    public String deleteById(int id) {
        rescuerRepo.deleteById(id);
        return "delete successfully";
    }

}
