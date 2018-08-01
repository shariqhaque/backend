package com.example.mycar.demand.repository;

import com.example.mycar.demand.model.Demand;
import org.springframework.data.repository.CrudRepository;

public interface DemandRepository extends CrudRepository<Demand,Long> {
}
