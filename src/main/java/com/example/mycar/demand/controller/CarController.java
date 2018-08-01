package com.example.mycar.demand.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.example.mycar.demand.model.Car;
import com.example.mycar.demand.model.Location;
import com.example.mycar.demand.service.CarService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

  @Autowired
  CarService carService;

  @PostMapping
  @ResponseStatus(CREATED)
  public Car create(@RequestBody Car car) {
    return carService.createCar(car);
  }

  @ResponseStatus(NO_CONTENT)
  @PutMapping("/{id}")
  public void updateCar(
      @PathVariable Long id, @RequestBody Car car) {
    carService.updateCar(id, car);
  }

  @GetMapping("/{id}")
  public Car getCarById(
      @PathVariable(required = false, name = "id") Long id){
    return carService.getById(id);
  }
  @PutMapping("/{id}/location")
  public void updateCarLocation(@PathVariable Long id, @RequestBody Location car){
        carService.updateCarLocation(id,car);

  }
  @GetMapping
  public List<Car> getCars(){
    return carService.findAll();
  }
}
