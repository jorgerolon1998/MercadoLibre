package com.mercadolibre.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.challenge.model.Human;
import com.mercadolibre.challenge.service.HumanService;

@RestController
public class MutantController {
	
	@Autowired
	private HumanService humanService;
	
	@PostMapping("/mutant")
	public ResponseEntity<Human> isMutant(@RequestBody Human human) {

		humanService.saveHuman(human);

		if (human.isMutant()) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
		
}
