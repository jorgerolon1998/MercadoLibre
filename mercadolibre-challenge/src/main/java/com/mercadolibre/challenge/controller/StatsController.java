package com.mercadolibre.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.challenge.model.Stats;
import com.mercadolibre.challenge.service.HumanService;

@RestController
public class StatsController {
	
	@Autowired
	private HumanService humanService;
	
	@GetMapping("/stats")
	public ResponseEntity<Stats> getStats(){
		return ResponseEntity.ok().body(humanService.getStats());
	}
}
