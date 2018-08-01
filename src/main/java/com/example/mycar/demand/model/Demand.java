package com.example.mycar.demand.model;

import java.sql.Date;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Demand {
  @Id
  @GeneratedValue
  private Long id;
  private Date pickUpTime;
  private Date dropOffTime;
  @OneToOne( targetEntity=Location.class )
  private Location pickLocation;
  @OneToOne( targetEntity=Location.class )
  private Location dropOffLocation;
  @OneToOne(targetEntity = Features.class)
  private Features features;
  @OneToOne(targetEntity = User.class)
  private User user;

}
