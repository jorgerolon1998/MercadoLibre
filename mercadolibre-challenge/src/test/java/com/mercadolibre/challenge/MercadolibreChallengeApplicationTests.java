package com.mercadolibre.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mercadolibre.challenge.controller.MutantController;
import com.mercadolibre.challenge.controller.StatsController;

@SpringBootTest
class MercadolibreChallengeApplicationTests {

	@MockBean
	private MutantController userController;
	
	@MockBean 
	private StatsController loanController;
	
	
	@Test
	public void applicationContextLoaded() {
	}
	
	@Test
	void contextLoads() {
		assertThat(userController).isNotNull();
		assertThat(loanController).isNotNull();

	}
	
	@Test
	public void applicationContextTest() {
	  MercadolibreChallengeApplication.main(new String[] {});
	}

}
