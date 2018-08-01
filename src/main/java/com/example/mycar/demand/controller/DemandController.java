package com.example.mycar.demand.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.example.mycar.demand.model.Demand;
import com.example.mycar.demand.model.User;
import com.example.mycar.demand.service.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demand")
public class DemandController {
  @Autowired
  DemandService demandService;

  @PostMapping
  @ResponseStatus(CREATED)
  public Demand create(@RequestBody Demand demand) {
    return demandService.createDemand(demand);
  }

  @ResponseStatus(NO_CONTENT)
  @PutMapping("/{id}")
  public void updateDemand(
      @PathVariable Long id, @RequestBody Demand demand) {
    demandService.updateDemand(id, demand);
  }

  @GetMapping("/{id}")
  public Demand getDemandById(
      @PathVariable(required = false, name = "id") Long id){
    return demandService.getById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteDemand(
      @PathVariable(required = false, name = "id") Long id){
    demandService.deleteDemand(id);
  }

}
