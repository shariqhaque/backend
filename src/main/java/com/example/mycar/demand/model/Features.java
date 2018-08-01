package com.example.mycar.demand.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class Features {
  @Id
  @GeneratedValue
  @Setter
  private Long id;
  private String model;
  private String engine;
  private String infotainmentSystem;
}
