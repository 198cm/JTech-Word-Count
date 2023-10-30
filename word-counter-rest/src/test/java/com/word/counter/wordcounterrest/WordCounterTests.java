package com.word.counter.wordcounterrest;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordCounterTests {

    @Test
    public void testCalculateHighestFrequency() {
        WordCounter wordCounter = new WordCounter();
        String text = "Dit is een voorbeeld text, deze text gebruikt voorbeeld woorden.";
        int highestFrequency = wordCounter.calculateHighestFrequency(text);
        assertEquals(2, highestFrequency);
    }

    @Test
    public void testCalculateFrequencyForWord() {
        WordCounter wordCounter = new WordCounter();
        String text = "Dit is een voorbeeld text, deze text gebruikt voorbeeld woorden.";
        int frequency = wordCounter.calculateFrequencyForWord(text, "text");
        assertEquals(2, frequency);
    }

    @Test
    public void testCalculateMostFrequentNWords() {
        WordCounter wordCounter = new WordCounter();
        String text = "Dit is een voorbeeld text, deze text gebruikt voorbeeld woorden.";
        List<WordFrequency> mostFrequentWords = wordCounter.calculateMostFrequentNWords(text, 2);

        assertEquals(2, mostFrequentWords.size());
        assertEquals("text", mostFrequentWords.get(0).getWord());
        assertEquals(2, mostFrequentWords.get(0).getFrequency());
        assertEquals("voorbeeld", mostFrequentWords.get(1).getWord());
        assertEquals(2, mostFrequentWords.get(1).getFrequency());
    }

}