package com.example.mycar.demand.repository;

import com.example.mycar.demand.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
