package com.mercadolibre.challenge.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mercadolibre.challenge.model.Human;
import com.mercadolibre.challenge.model.Stats;
import com.mercadolibre.challenge.repository.HumanRepository;
import com.mercadolibre.challenge.util.exceptions.InvalidDnaSequenceException;

@SpringBootTest
public class HumanServiceImplTest {
	
	@Autowired
	private HumanService humanService;
	
	@MockBean
	private HumanRepository humanRepository;
	
	private Stats stats;
	
	private Human human;
	
	private String[] mutantDna = {"ATGCGA","CAGTGC","TTATGT","AGAAAA","CCCTTA","TAACTG"};
	
	private String[] normalDna = {"GGGCCC","ATATAT","GCGCGC","ATATAT","GCGCGC","ATATAT"};
	
	private String[] invalidDna = {"ZZZZ"};
	
	@BeforeEach
	public void setUp() {
		when(humanRepository.count()).thenReturn(new Long(10));
		when(humanRepository.countByMutant(true)).thenReturn(new Long(2));
		stats = humanService.getStats();
	}
	
	@Test
	public void shouldReturnMutantsQuantity() {
    	assertThat(stats.getMutantQuantity().equals(new Long(2)));
	}
	
	@Test
	public void shouldReturnHumansQuantity() {		
    	assertThat(stats.getHumanQuantity().equals(new Long(10)));
	}
	
	@Test
	public void assertMutantRatio() {		
    	assertThat(stats.getRatio().equals(new Double(0.2)));
	}
	
	@Test
	public void assertMutant() {
		human = new Human(mutantDna);
		humanService.saveHuman(human);
		assertTrue(human.isMutant());
	}
	
	@Test
	public void assertNormal() {
		human = new Human(normalDna);
		humanService.saveHuman(human);
		assertFalse(human.isMutant());
	}
	
	@Test
	public void shouldThrowInvalidDNAException() {
	  Assertions.assertThrows(InvalidDnaSequenceException.class, () -> {
		  	human = new Human(invalidDna);
			humanService.saveHuman(human);
	  });
	}
	
}
