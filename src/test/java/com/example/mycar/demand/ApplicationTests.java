package com.example.mycar.demand;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.mycar.demand.model.Demand;
import com.example.mycar.demand.model.Location;
import com.example.mycar.demand.model.User;
import com.example.mycar.demand.service.DemandService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	DemandService demandService;

	@Test
	public void shouldCreateDemand() {
		final Location pick = Location.builder().id(100001L).build();
		final Location drop = Location.builder().id(100002L).build();
		final Demand demand = Demand.builder().dropOffLocation(drop).pickLocation(pick)
				.user(User.builder().id(1000013L).build()).build();
		final Demand createdDemand = demandService.createDemand(demand);
		assertThat(createdDemand.getPickLocation().getId()).isEqualTo(100001L);
	}

	@Test
	public void shouldNotCreateDemand() {
		final Location pick = Location.builder().id(100001L).build();
		final Location drop = Location.builder().id(100002L).build();
		final Demand demand = Demand.builder().dropOffLocation(drop).pickLocation(pick)
				.user(User.builder().id(1000028L).build()).build();
		final Demand createdDemand = demandService.createDemand(demand);
		assertThat(createdDemand).isNull();
	}


}
