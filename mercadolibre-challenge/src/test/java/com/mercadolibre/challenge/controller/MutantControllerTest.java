package com.mercadolibre.challenge.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.mercadolibre.challenge.model.Human;
import com.mercadolibre.challenge.service.HumanService;

@SpringBootTest
public class MutantControllerTest {

		
	@Mock 
	private HumanService humanService;
	@InjectMocks 
	private MutantController humanController = new MutantController(); 
	
	private Human human;
	
	private String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAAA","CCCTTA","TAACTG"};
	
	@BeforeEach
	public void setUp() {
		human = new Human(dna);
	}
	
	@Test
	public void assertMutantResponseStatusCode() {
		human.setMutant(true);
		ResponseEntity<?> response = humanController.isMutant(human);
    	assertThat(HttpStatus.OK.equals(response.getStatusCode()));
	}
	
	@Test
	public void assertIsNotMutantResponseStatusCode() {
		human.setMutant(false);
		ResponseEntity<?> response = humanController.isMutant(human);
    	assertThat(HttpStatus.FORBIDDEN.equals(response.getStatusCode()));
	}		

		
	}