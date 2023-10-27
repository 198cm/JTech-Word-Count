package com.word.counter.wordcounterrest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterRestApplicationTests {

	private WordCounterController controller;

	@BeforeEach
	public void setUp() {
		controller = new WordCounterController();
	}

	@Test
	public void testGetHighestFrequencyRest() {
		String inputText = "World World World Hello";
		int expectedFrequency = 3;
		ResponseEntity<?> response = controller.getHighestFrequencyRest(inputText);
		assertEquals(ResponseEntity.ok(expectedFrequency), response);
	}

	@Test
	public void testCalculateFrequencyForWordRest() {
		String inputText = "World Hello World";
		String word = "Hello";
		int expectedFrequency = 1;
		ResponseEntity<?> response = controller.calculateFrequencyForWordRest(inputText, word);
		assertEquals(ResponseEntity.ok(expectedFrequency), response);
	}

	@Test
	public void testCalculateMostFrequentNWordsRest() {
		String inputText = "World World World Hello Hello Hello";
		int n = 2;
		String expectedResponse = "hello 3\rworld 3";
		ResponseEntity<String> response = controller.calculateMostFrequentNWordsRest(inputText, n);
		assertEquals(ResponseEntity.ok(expectedResponse), response);
	}
}
