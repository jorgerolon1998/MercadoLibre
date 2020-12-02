package com.mercadolibre.challenge.util.detector;

import java.util.Arrays;
import java.util.List;

import com.mercadolibre.challenge.util.exceptions.InvalidDnaSequenceException;


public class MutantDetector {

	static int MUTANT_SEQUENCE_LENGTH = 4;
	static int SEQUENCES_FOR_SUCCESS = 2;
	static List<Character> POSSIBLE_LETTERS = Arrays.asList('A', 'T', 'C', 'G');

	private String[] dna;
	private int currentSequences;
	private int consecutive;

	public MutantDetector(String[] dna) {
		this.dna = dna;
	}

	public boolean isMutant() {
		currentSequences = 0;
		validateTableSize();
		readRows();
		readColumns();
		readUpFowardDiagonals();
		readDownFowardDiagonals();
		return currentSequences >= SEQUENCES_FOR_SUCCESS;
	}

	private void readRows() {
		for (int i = 0; i < dna.length; i++) {

			validateRow(i);
			validateCharAt(i,0);
			consecutive = 0;
			
			for (int j = 0; j < dna.length - 1; j++) {
				validateCharAt(i, j + 1);
				readPosition(i, j, i, j + 1);
			}
		}
	}

	private void readColumns() {
		int j = 0;
		while (keepChecking() && j < dna.length) {

			int i = 0;
			consecutive = 0;

			while (keepChecking() && enoughRemainingSpace(dna.length - i)) {
				readPosition(i, j, i + 1, j);
				i++;
			}
			j++;
		}
	}

	private void readUpFowardDiagonals() {
		int row = MUTANT_SEQUENCE_LENGTH - 1;
		while (keepChecking() && row < dna.length) {

			int i = row;
			int j = 0;
			
			while (keepChecking() && enoughRemainingSpace((row + 1) - j)) {
				readPosition(i, j, i - 1, j + 1);
				i--;
				j++;
			}
			row++;
		}
		int column = 1;
		while (keepChecking() && column < (dna.length - MUTANT_SEQUENCE_LENGTH + 1)) {

			int i = dna.length - 1;
			int j = column;
			while (keepChecking() && enoughRemainingSpace(dna.length - j)) {
				readPosition(i, j, i - 1, j + 1);
				i--;
				j++;
			}
			column++;
		}
	}

	private void readDownFowardDiagonals() {
		int row = dna.length - MUTANT_SEQUENCE_LENGTH;
		while (keepChecking() && row >= 0) {

			int i = row;
			int j = 0;
			while (keepChecking() && enoughRemainingSpace((dna.length - row) - j)) {
				readPosition(i, j, i + 1, j + 1);
				i++;
				j++;
			}
			row--;
		}
		int column = 1;
		while (keepChecking() && column < (dna.length - MUTANT_SEQUENCE_LENGTH + 1)) {
			int i = 0;
			int j = column;
			
			while (keepChecking() && enoughRemainingSpace((dna.length - column) - i)) {
				readPosition(i, j, i + 1, j + 1);
				i++;
				j++;
			}
			column++;
		}
	}

	private void readPosition(int i, int j, int nextI, int nextJ) {
		char currentChar = getCharAt(i, j);
		char nextChar = getCharAt(nextI, nextJ);

		if (currentChar == nextChar) {
			consecutive++;
		}else {
			consecutive = 0;
		}
		if (consecutive == MUTANT_SEQUENCE_LENGTH - 1) {
			currentSequences++;
			consecutive = 0;
		}
	}

	private boolean keepChecking() {
		return currentSequences < SEQUENCES_FOR_SUCCESS;
	}
	
	private boolean enoughRemainingSpace(int remainingSpace) {
		return remainingSpace >= MUTANT_SEQUENCE_LENGTH - consecutive ;
	}

	private char getCharAt(int i, int j) {
		return dna[i].charAt(j);
	}

	private void validateCharAt(int i, int j) {
		char c = getCharAt(i, j);
		if (!POSSIBLE_LETTERS.contains(c)) {
			throw new InvalidDnaSequenceException("Invalid Character '" + c + "' at position (" + j + "," + i + ").");
		}
	}

	private void validateRow(int i) {
		if (dna[i].length() != dna.length) {
			throw new InvalidDnaSequenceException("Row " + i + " does not match dna array lenght. Table should be NxN.");
		}
	}

	private void validateTableSize() {
		if (dna.length < MUTANT_SEQUENCE_LENGTH) {
			throw new InvalidDnaSequenceException("Table should be at least " + MUTANT_SEQUENCE_LENGTH + "x" + MUTANT_SEQUENCE_LENGTH + ".");
		}
	}

}