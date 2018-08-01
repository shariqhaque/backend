package com.example.mycar.demand.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import com.example.mycar.demand.model.Car;
import com.example.mycar.demand.model.User;
import com.example.mycar.demand.service.UserService;
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
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping
  @ResponseStatus(CREATED)
  public User create(@RequestBody User user) {
    return userService.createUser(user);
  }

  @ResponseStatus(NO_CONTENT)
  @PutMapping("/{id}")
  public void updateCar(
      @PathVariable Long id, @RequestBody User user) {
    userService.updateUser(id, user);
  }

  @GetMapping("/{id}")
  public User getCarById(
      @PathVariable(required = false, name = "id") Long id){
    return userService.getById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(
      @PathVariable(required = false, name = "id") Long id){
     userService.deleteUser(id);
  }

}
