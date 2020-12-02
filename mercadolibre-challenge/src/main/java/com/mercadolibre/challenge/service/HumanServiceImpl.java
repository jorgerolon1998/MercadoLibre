package com.mercadolibre.challenge.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.challenge.model.Human;
import com.mercadolibre.challenge.model.Stats;
import com.mercadolibre.challenge.repository.HumanRepository;
import com.mercadolibre.challenge.util.detector.MutantDetector;

@Service
@Transactional
public class HumanServiceImpl implements HumanService{
	
	@Autowired
	private HumanRepository humanRepository;

	@Override
	public Human saveHuman(Human human) {
		boolean isMutant = isMutant(human.getDna());
		human.setMutant(isMutant);
		return humanRepository.save(human);
	}
	
	public boolean isMutant(String[] dna) {
		return new MutantDetector(dna).isMutant();
	}
	
	public Stats getStats() {
		Long mutantsQuantity = humanRepository.countByMutant(true);
		Long humanQuantity = humanRepository.count();
		return new Stats(humanQuantity, mutantsQuantity);
	}

}
