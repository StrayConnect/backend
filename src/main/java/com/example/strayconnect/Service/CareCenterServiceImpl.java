package com.example.strayconnect.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.strayconnect.Model.CareCenter;
import com.example.strayconnect.Model.City;
import com.example.strayconnect.Repository.CityRepo;
import com.example.strayconnect.Repository.CareCenterRepo;

@Service
public class CareCenterServiceImpl implements CareCenterService {
    private CityRepo cityRepo;
    private CareCenterRepo careCenterRepo;

    public CareCenterServiceImpl(CityRepo cityRepo, CareCenterRepo careCenterRepo) {
        this.cityRepo = cityRepo;
        this.careCenterRepo = careCenterRepo;
    }

    @Override
    public String add(Map<String, String> careCenter) {
        String street = careCenter.get("street");
        String cityName = careCenter.get("city");
        Long phone = Long.parseLong(careCenter.get("phone"));
        City city = cityRepo.findByCity(cityName);
        if (city == null) {
            System.out.println("city name not found hence entering it into database");
            City newCity = new City(cityName);
            cityRepo.save(newCity);
            city = newCity;
        }
        CareCenter newCareCenter = new CareCenter(street,city,phone);
        careCenterRepo.save(newCareCenter);
        return "careCenter added successfully";
    }

    @Override
    public List<CareCenter> getAll() {
        return careCenterRepo.findAll();
    }

    @Override
    public Optional<CareCenter> get(int id) {
        Optional<CareCenter> careCenter = careCenterRepo.findById(id);
        return careCenter;
    }

    @Override
    public String update(Map<String, String> careCenter) {
        int careCenterId = Integer.parseInt(careCenter.get("centerId"));
        if (careCenterRepo.findById(careCenterId).isPresent()) {
            String street = careCenter.get("street");
            String cityName = careCenter.get("city");
            Long phone = Long.parseLong(careCenter.get("phone"));
            City city = cityRepo.findByCity(cityName);
            if (city == null) {
            System.out.println("city name not found hence entering it into database");
            City newCity = new City(cityName);
            cityRepo.save(newCity);
            city = newCity;
            }
            CareCenter newCareCenter = new CareCenter(careCenterId,street,city,phone);
            careCenterRepo.save(newCareCenter);

            return "careCenter updated successfully";
        } else 
        {
            return "invalid careCenter id";
        }

    }

    @Override
    public String deleteById(int id) {
        careCenterRepo.deleteById(id);
        return "delete successfully";
    }

}
