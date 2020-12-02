package com.mercadolibre.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mercadolibre.challenge.util.serializer.DecimalJsonSerializer;

public class Stats {
	
	private Long mutants;
	
	private Long humans;
	
	public Stats(Long humans, Long mutants) {
		this.humans = humans;
		this.mutants = mutants;
	}
	
	@JsonProperty("ratio")
	@JsonSerialize(using = DecimalJsonSerializer.class)
	public Double getRatio() {
		return (double) mutants / (double) humans;
	}
	
	@JsonProperty("count_human_dna")
	public Long getHumanQuantity() {
		return humans;
	}
	
	@JsonProperty("count_mutant_dna")
	public Long getMutantQuantity() {
		return mutants;
	}

}
