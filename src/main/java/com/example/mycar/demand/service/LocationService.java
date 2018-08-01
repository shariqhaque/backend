package com.example.mycar.demand.service;

import com.example.mycar.demand.model.Location;
import com.example.mycar.demand.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
  @Autowired
  LocationRepository locationRepository;

  Location createUpdateLocation(Location location){
    return locationRepository.save(location);
  }

}
