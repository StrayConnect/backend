package com.example.strayconnect.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.strayconnect.Model.CareCenter;
import com.example.strayconnect.Model.City;
import com.example.strayconnect.Model.Doctor;
import com.example.strayconnect.Repository.CareCenterRepo;
import com.example.strayconnect.Repository.CityRepo;
import com.example.strayconnect.Repository.DoctorRepo;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepo doctorRepo;
    private CityRepo cityRepo;
    private CareCenterRepo careCenterRepo;

    public DoctorServiceImpl(DoctorRepo doctorRepo, CityRepo cityRepo, CareCenterRepo careCenterRepo) {
        this.cityRepo = cityRepo;
        this.doctorRepo = doctorRepo;
        this.careCenterRepo = careCenterRepo;
    }

    @Override
    public String add(Map<String, String> doctor) {
        // String email, String fname, String lname, long phone, String street, City
        // city,CareCenter center
        String email = doctor.get("email");
        String fname = doctor.get("fname");
        String lname = doctor.get("lname");
        Long phone = Long.parseLong(doctor.get("phone"));
        String street = doctor.get("street");
        String cityName = doctor.get("city");
        String password = doctor.get("password");
        City city = cityRepo.findByCity(cityName);
        if (city == null) {
            System.out.println("city is not in database hence adding to database");
            City c = new City(cityName);
            cityRepo.save(c);
            city = c;
        }
        int centerId = Integer.parseInt(doctor.get("center"));
        Optional<CareCenter> center = careCenterRepo.findById(centerId);
        if (center.isPresent()) {
            System.out.println("inside present");
            CareCenter c1 = center.get();
            Doctor newDoctor = new Doctor(email, fname, lname, phone, street, city, c1, password);
            doctorRepo.save(newDoctor);
            return "doctor added successfully";
        } else {
            System.out.println("inside else");
            return "center not exist of that care center id hence enter correct carecenter id to add";
        }

    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepo.findAll();
    }

    @Override
    public Optional<Doctor> get(int id) {
        Optional<Doctor> doctor = doctorRepo.findById(id);
        return doctor;
    }

    @Override
    public String update(Map<String, String> doctor) {
        int docId = Integer.parseInt(doctor.get("docId"));

        // checking doctor exist for docId or not
        if (doctorRepo.findById(docId).isPresent()) {
            String email = doctor.get("email");
            String fname = doctor.get("fname");
            String lname = doctor.get("lname");
            Long phone = Long.parseLong(doctor.get("phone"));
            String street = doctor.get("street");
            String cityName = doctor.get("city");
            City city = cityRepo.findByCity(cityName);
            if (city == null) {
                System.out.println("city is not in database hence adding to database");
                City c = new City(cityName);
                cityRepo.save(c);
                city = c;
            }
            int centerId = Integer.parseInt(doctor.get("center"));
            Optional<CareCenter> center = careCenterRepo.findById(centerId);
            if (center.isPresent()) {
                System.out.println("inside present");
                CareCenter c1 = center.get();
                Doctor newDoctor = new Doctor(docId, email, fname, lname, phone, street, city, c1);
                doctorRepo.save(newDoctor);
                return "doctor updated successfully";
            } else {
                System.out.println("inside else");
                return "center not exist of that care center id so give correct care centerId to update";
            }
        } else {
            return "doctor not exist for this doctor id";
        }

    }

    @Override
    public String deleteById(int id) {
        doctorRepo.deleteById(id);
        return "delete successfully";
    }

}
