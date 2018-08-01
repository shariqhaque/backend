package com.example.mycar.demand.repository;

import com.example.mycar.demand.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {

}
