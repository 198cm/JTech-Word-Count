package com.word.counter.wordcounterrest;

import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WordCounterController {

    private final WordCounter wordCounter;

    @Autowired
    public WordCounterController() {
        this.wordCounter = new WordCounter();
    }

    /**
     * The REST version of the WordCounter method: calculateHighestFrequency
     * @param text The text the function is going to be searching through.
     * @return the highest frequency in the text (several words might have this frequency) In case of a failure, the function returns error messages.
     */
    @GetMapping("/v1/calculateHighestFrequency")
    public ResponseEntity<?> getHighestFrequencyRest(@RequestParam(value = "text", defaultValue = "World World") String text) {
        if (text == null || text.isEmpty()) {
            return ResponseEntity.badRequest().body("The 'text' parameter must be provided and not empty.");
        }

        try {
            int highestFrequency = wordCounter.calculateHighestFrequency(text);
            return ResponseEntity.ok(highestFrequency);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the request.");
        }
    }

    /**
     * The REST version of the WordCounter method: calculateFrequencyForWord
     * @param text The text the function is going to be searching through.
     * @param word The word the function is going to calculate the frequency of.
     * @return the frequency of the specified word. In case of a failure, the function returns error messages.
     */
    @GetMapping("/v1/calculateFrequencyForWord")
    public ResponseEntity<?> calculateFrequencyForWordRest(@RequestParam(value = "text", defaultValue = "World") String text, @RequestParam(value = "word", defaultValue = "World") String word) {

        if (text == null || text.isEmpty() || word == null || word.isEmpty()) {
            return ResponseEntity.badRequest().body("Both 'text' and 'word' must be provided and not empty.");
        }

        try {
            int frequencyForWord = wordCounter.calculateFrequencyForWord(text, word);
            return ResponseEntity.ok(frequencyForWord);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the request.");
        }
    }

    /**
     *  The REST version of the WordCounter method: calculateMostFrequentNWords()
     * @param text The text the function is going to be searching through.
     * @param n Number of words returned
     * @return a list of the most frequent „n‟ words in the input text, all the words returned in lower case. If several words have the same frequency, this method returns them in ascendant alphabetical order. In case of a failure, the function returns error messages.
     */
    @GetMapping("/v1/calculateMostFrequentNWords")
    public ResponseEntity<String> calculateMostFrequentNWordsRest(@RequestParam(value = "text", defaultValue = "World World World Hello hello I") String text, @RequestParam(value = "n", defaultValue = "3") int n) {
        if (n <= 0) {
            return ResponseEntity.badRequest().body("Invalid value for 'n'. Please provide a positive integer.");
        }

        try {
            StringJoiner msg = new StringJoiner(" ");
            for (WordFrequency word : wordCounter.calculateMostFrequentNWords(text, n)) {
                msg.add(word.getWord() + " " + word.getFrequency());
            }
            return ResponseEntity.ok(msg.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while processing the request.");
        }
    }
}