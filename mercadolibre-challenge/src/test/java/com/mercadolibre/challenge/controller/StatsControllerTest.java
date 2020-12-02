package com.mercadolibre.challenge.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.mercadolibre.challenge.model.Stats;
import com.mercadolibre.challenge.service.HumanService;

@SpringBootTest
public class StatsControllerTest {
	
	@Mock
	private HumanService humanService;
	@InjectMocks 
	private StatsController statsController = new StatsController();	
 	
	@BeforeEach
	public void setUp() {
		when(humanService.getStats()).thenReturn(new Stats(new Long(100), new Long(40)));
	}
	
	@Test
	public void test_stats() {
    	assertThat(statsController.getStats().getBody().getRatio() == 2.5);
	}

}
