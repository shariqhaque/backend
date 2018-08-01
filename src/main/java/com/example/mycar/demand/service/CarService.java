package com.example.mycar.demand.service;

import com.example.mycar.demand.model.Car;
import com.example.mycar.demand.model.Location;
import com.example.mycar.demand.repository.CarRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

  @Autowired
  CarRepository carRepository;

  @Autowired LocationService locationService;

  public Car createCar(Car car){
    final Location location = locationService.createUpdateLocation(car.getLocation());
    car.setLocation(location);
    return carRepository.save(car);
  }

  public void updateCar(Long id, Car car) {
    car.setId(id);
    carRepository.save(car);
  }

  public Car getById(Long id) {
    return carRepository.findById(id).orElseThrow(null);
  }

  public void updateCarLocation(Long id, Location location) {
    final Car carToUpdate = carRepository.findById(id).get();
    final Location updateLocation = locationService.createUpdateLocation(location);
    carToUpdate.setLocation(updateLocation);
    carRepository.save(carToUpdate);
  }

  public List<Car> findAll() {
    List<Car>  cars=new ArrayList<>();
     carRepository.findAll().forEach(car-> {
       cars.add(car);
     });
     return cars;
  }
}
