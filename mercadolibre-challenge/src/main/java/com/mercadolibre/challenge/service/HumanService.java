package com.mercadolibre.challenge.service;

import com.mercadolibre.challenge.model.Human;
import com.mercadolibre.challenge.model.Stats;

public interface HumanService {
	
	Human saveHuman(Human human);
	
	Stats getStats();
	
}
