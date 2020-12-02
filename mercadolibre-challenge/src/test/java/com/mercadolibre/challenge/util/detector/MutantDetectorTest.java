package com.mercadolibre.challenge.util.detector;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mercadolibre.challenge.util.exceptions.InvalidDnaSequenceException;

public class MutantDetectorTest {
	
	@Test
	public void assertIsMutant() {
		
		String[] dna = { "TAAAAT", "GGCCCC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
		assertTrue(new MutantDetector(dna).isMutant());	
		}

	@Test
	public void assertIsNotMutant() {
		String[] dna = { "GGGGCC", "AAATAT", "GCGCGC", "ATATAT", "GCGCGC", "ATATAT" };
		assertFalse(new MutantDetector(dna).isMutant());	
	}
	
	@Test
	public void assertIsMutantWithMultipleCorrectsSequence() {
		String[] dna = { "ATATAT", "GCGCGT", "ATATAT", "ACGCGT", "ATATAT", "ACGCGC" };
		assertTrue(new MutantDetector(dna).isMutant());	
	}

	@Test
	public void assertIsMutantWithCorrectDiagonalSequences() {
		String[] dna = { "ATGTGA", "CATTGC", "TTATTT", "TGAAGG", "GCGTCA", "TCACTG" };
		assertTrue(new MutantDetector(dna).isMutant());	
	}

	@Test
	public void assertFalseIsMutantWithCorrectDiagonalUniqueSequence() {
		String[] dna = { "ATGGGA", "CATTGC", "TTATTT", "TGAAGG", "GCGTCA", "TCACTG" };
		assertFalse(new MutantDetector(dna).isMutant());	
	}

	@Test
	public void assertIsMutantWithTwoCorrectDiagonalsInsideSequence() {
		String[] dna = { "GTGTGA", "CATTGC", "TTATTT", "TGAAGG", "GCGTAA", "TCACTG" };
		assertTrue(new MutantDetector(dna).isMutant());	
	}

	@Test
	public void assertFalseWithOnlyOneVerticalCorrectSequence() {
		String[] dna = { "ATATAT", "ACGCGC", "ATATAT", "ACGCGC", "ATATAT", "GCGCGC" };
		assertFalse(new MutantDetector(dna).isMutant());	
	}

	@Test
	public void assertFalseWithOnlyOneDiagonalCorrectSequence() {
		String[] dna = { "ATATAT", "GCGCTC", "ATATAT", "GCTCGC", "ATATAT", "GCGCGC" };
		assertFalse(new MutantDetector(dna).isMutant());	
	}

	@Test
	public void assertIsMutantWithFiveSeriesSequencetest_is_mutant_with_one_sequence_of_five_and_one_sequence_of_four() {
		String[] dna = { "AAAAAT", "GCGCGC", "GTATAT", "GCGCGC", "GTATAT", "CCGCGC" };
		assertTrue(new MutantDetector(dna).isMutant());	
	}


	@Test
	public void assertFalseWitTenRowTable() {
		String[] dna = { "ATATATATAC", "CGCGCGCGCC", "ATATATATAG", "CGCGCGCGCA", "ATATATATAG", "CGCGCGCGCA", "ATATATATAG",
				"CGCGCGCGCA", "ATATATATAG", "ATATATATAA"};
		assertFalse(new MutantDetector(dna).isMutant());	
	}

	@Test
	public void assertIsMutantWithTwoHorizontalSequences() {
		String[] dna = { "ATATATATA", "CGGGGGGGG", "ATATATATA", "CGCGCGCGC", "ATATATATA", "CGCGCGCGC", "ATATATATA",
				"CGCGCGCGC", "AAAAATATA" };
		assertTrue(new MutantDetector(dna).isMutant());	
	}

	@Test
	public void assertIsMutantWithTwoVerticalSequences() {
		String[] dna = { "ATATATATA", "CGCGCGCGC", "ATATATAGA", "CGCGCGCGC", "ATATATAGA", "CGCGCGCGC", "ATATATAGA",
				"CGCGCGCGC", "ATATATAGA" };
		assertTrue(new MutantDetector(dna).isMutant());	
	}

	@Test
	public void assertIsMutantWithTwoDiagonalSequences() {
		String[] dna = { "ATATATATA", "CGCGCGCAC", "ATATATATA", "CGCGCACGC", "ATATATATA", "CGCACGCGT", "ATATATATA",
				"CACGCGTGC", "ATATATATA" };
		assertTrue(new MutantDetector(dna).isMutant());	
	}
	
	@Test
	public void shouldThrowInvalidDNAExceptionWithInvalidCharacter() {
		String[] invalidDna = {"ZZZZ","AAAA","MMMM","TTTT"};
	  Assertions.assertThrows(InvalidDnaSequenceException.class, () -> {
		  new MutantDetector(invalidDna).isMutant();
	  });
	}
	
	@Test
	public void shouldThrowInvalidDNAExceptionWithInvalidDimentions() {
		String[] invalidDna = {"AAAAAT","GCGCGC","GCGCGC","GCGCGC"};
	  Assertions.assertThrows(InvalidDnaSequenceException.class, () -> {
		  new MutantDetector(invalidDna).isMutant();
	  });
	}

}
