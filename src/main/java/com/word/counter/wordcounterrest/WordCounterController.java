package com.word.counter.wordcounterrest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordCounterController {


    @GetMapping("/calculateHighestFrequency")
    public int calculateHighestFrequencyRest(@RequestParam(value = "text", defaultValue = "World World") String text) {
        return new WordCounter().calculateHighestFrequency(text);
    }

    @GetMapping("/calculateFrequencyForWord")
    public int calculateFrequencyForWord(@RequestParam(value = "text", defaultValue = "World") String text, @RequestParam(value = "word", defaultValue = "World") String word) {
        return new WordCounter().calculateFrequencyForWord(text, word);
    }

    @GetMapping("/calculateMostFrequentNWords")
    public String calculateMostFrequentNWords(@RequestParam(value = "text", defaultValue = "World World World Hello hello I") String text, @RequestParam(value = "n", defaultValue = "3") int n) {
        StringBuilder msg = new StringBuilder();
        for (WordFrequency word: new WordCounter().calculateMostFrequentNWords(text, n)) {
            msg.append(word.getWord()).append(" ").append(word.getFrequency()).append("\r");
        }

        return msg.toString();
    }
}