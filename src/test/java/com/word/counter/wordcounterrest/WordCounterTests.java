package com.word.counter.wordcounterrest;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordCounterTests {

    @Test
    public void testCalculateHighestFrequency() {
        WordCounter wordCounter = new WordCounter();
        String text = "This is a sample text. This text contains some sample words.";
        int highestFrequency = wordCounter.calculateHighestFrequency(text);
        assertEquals(2, highestFrequency);
    }

    @Test
    public void testCalculateFrequencyForWord() {
        WordCounter wordCounter = new WordCounter();
        String text = "This is a sample text. This text contains some sample words.";
        int frequency = wordCounter.calculateFrequencyForWord(text, "sample");
        assertEquals(2, frequency);
    }

    @Test
    public void testCalculateMostFrequentNWords() {
        WordCounter wordCounter = new WordCounter();
        String text = "This is a sample text. This text contains some sample words.";
        List<WordFrequency> mostFrequentWords = wordCounter.calculateMostFrequentNWords(text, 2);

    }
}