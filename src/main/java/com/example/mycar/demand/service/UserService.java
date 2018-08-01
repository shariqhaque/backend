package com.example.mycar.demand.service;

import com.example.mycar.demand.model.User;
import com.example.mycar.demand.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  public User createUser(User user) {
    return userRepository.save(user);

  }

  public void updateUser(Long id, User user) {
    user.setId(id);
    userRepository.save(user);
  }

  public User getById(Long id) {
    return userRepository.findById(id).get();
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
