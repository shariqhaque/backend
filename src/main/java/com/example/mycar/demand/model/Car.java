package com.example.mycar.demand.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
  @Id
  @GeneratedValue
  private Long id;
  private String model;
  private String engine;
  private String infotainmentSystem;
  @OneToOne( targetEntity=Location.class )
  private Location location;
}
