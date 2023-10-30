package com.word.counter.wordcounterrest;
import java.util.List;

public interface WordFrequencyAnalyzer extends WordFrequency {
    int calculateHighestFrequency(String text);
    int calculateFrequencyForWord (String text, String word);
    List<WordFrequency> calculateMostFrequentNWords (String text, int n);
}
