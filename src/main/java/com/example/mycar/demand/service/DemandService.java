package com.example.mycar.demand.service;

import com.example.mycar.demand.model.Demand;
import com.example.mycar.demand.model.Location;
import com.example.mycar.demand.model.User;
import com.example.mycar.demand.repository.DemandRepository;
import com.example.mycar.demand.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandService {

  @Autowired
  DemandRepository demandRepository;

  @Autowired LocationService locationService;

  @Autowired
  UserRepository userRepository;

  public Demand createDemand(Demand demand) {
    if(demand.getPickLocation()!=null){
      final Location updateLocation = locationService
          .createUpdateLocation(demand.getPickLocation());
      demand.setPickLocation(updateLocation);
    }
    if(demand.getDropOffLocation()!=null){
      final Location updateLocation = locationService
          .createUpdateLocation(demand.getDropOffLocation());
      demand.setDropOffLocation(updateLocation);
    }

    final Optional<User> byId = userRepository.findById(demand.getUser().getId());
    if(byId.isPresent()){
      return demandRepository.save(demand);
    }
    return null;
  }

  public void updateDemand(Long id, Demand demand) {
    demand.setId(id);
    demandRepository.save(demand);

  }

  public Demand getById(Long id) {
    return demandRepository.findById(id).get();
  }

  public void deleteDemand(Long id) {
    demandRepository.deleteById(id);
  }
}
