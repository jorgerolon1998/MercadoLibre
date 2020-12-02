package com.mercadolibre.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercadolibre.challenge.model.Human;

public interface HumanRepository extends JpaRepository<Human, Long>{
	
	Long countByMutant(boolean isMutant);

}
