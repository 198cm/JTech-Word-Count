package com.word.counter.wordcounterrest;

import java.util.*;

public class WordCounter implements WordFrequencyAnalyzer{

    /**
     * @param text The text the function is going to be searching through.
     * @return the highest frequency in the text (several words might have this frequency)
     */
    @Override
    public int calculateHighestFrequency(String text) {
        Map<String, Integer> wordFrequencies = getStringIntegerMap(text);

        int highestWordCount = 0;
        for (int count : wordFrequencies.values()) {
            if (count > highestWordCount) {
                highestWordCount = count;
            }
        }

        return highestWordCount;
    }

    /**
     * @param text The text the function is going to be searching through.
     * @param word The word the function is going to calculate the frequency of.
     * @return the frequency of the specified word.
     */
    @Override
    public int calculateFrequencyForWord(String text, String word) {
        StringTokenizer tokenizer = new StringTokenizer(text, " ,.;%\n"); //StringTokenizer doesn't return an array but a single word -> easier for looping
        int wordCount = 0;

        String lowercaseWord = word.toLowerCase();

        while (tokenizer.hasMoreTokens()) {
            String singleWord = tokenizer.nextToken();
            if (lowercaseWord.equals(singleWord.toLowerCase())) {
                wordCount++;
            }
        }
        return wordCount;
    }

    /**
     * @param text The text the function is going to be searching through.
     * @param n Number of words returned
     * @return a list of the most frequent „n‟ words in the input text, all the words returned in lower case. If several words have the same frequency, this method returns them in ascendant alphabetical order.
     */
    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        Map<String, Integer> wordFrequencies = getStringIntegerMap(text); //Same as in the first function

        //Convert Map to Arraylist
        ArrayList<WordInfo> mostFrequentNWords = new ArrayList<>();
        for (Map.Entry<String, Integer> wordSet: wordFrequencies.entrySet()) { //This makes it, so you can get both the String and Integer from a map
          mostFrequentNWords.add(new WordInfo(wordSet.getKey(), wordSet.getValue()));
        }

        // Sort based on frequency, and if they're the same sort based on alphabetical order
        mostFrequentNWords.sort((w1, w2) -> {
            int freqComparison = Integer.compare(w2.getFrequency(), w1.getFrequency());
            if (freqComparison == 0) {
                return w1.getWord().compareTo(w2.getWord());
            }
            return freqComparison;
        });



        //Convert to List<WordFrequency>
        List<WordFrequency> result = new ArrayList<>(mostFrequentNWords);
        //See if the asked amount isn't higher than the size of the words so there is no error
        if (n > mostFrequentNWords.size()) {
            return result;
        }
        return result.subList(0, n);
    }

    private static Map<String, Integer> getStringIntegerMap(String text) {
        StringTokenizer tokenizer = new StringTokenizer(text, " ,.;%\n");  //StringTokenizer doesn't return an array but a single word -> easier for looping
        Map<String, Integer> wordFrequencies = new HashMap<>(); //Map stores the string together with the frequency of a word, makes it easier to store everything in a single object and not have nested for loops

        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase();
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1); //Puts new words into the Map and uses getOrDefault to update existing words.
        }
        return wordFrequencies;
    }

    /**
     * @return Not usable
     */
    @Override
    public String getWord() {
        return null;
    }

    /**
     * @return Not usable
     */
    @Override
    public int getFrequency() {
        return 0;
    }
}
