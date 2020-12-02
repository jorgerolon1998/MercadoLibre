package com.mercadolibre.challenge.util.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class InvalidDnaSequenceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidDnaSequenceException(String message) {
		super(message);
	}
	
}
