package com.mercadolibre.challenge.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String[] dna;

    private boolean mutant;
    
    public Human() {
    }
    
    public Human(String[] dna) {
    	this.dna = dna;
    }
    
	public String [] getDna() {
		return dna;
	}

	public void setDna(String [] dna) {
		this.dna = dna;
	}

	public boolean isMutant() {
		return mutant;
	}

	public void setMutant(boolean mutant) {
		this.mutant = mutant;
	}
    
    
    
    

}
