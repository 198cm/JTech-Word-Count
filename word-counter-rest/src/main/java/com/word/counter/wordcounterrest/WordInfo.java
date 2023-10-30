package com.word.counter.wordcounterrest;

public class WordInfo implements WordFrequency{
    String word;
    int frequency;

    public WordInfo(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    /**
     * @return Returns the word of the WordInfo Object
     */
    @Override
    public String getWord() {
        return this.word;
    }

    /**
     * @return Returns the frequency of the word of the WordInfo Object
     */
    @Override
    public int getFrequency() {
        return this.frequency;
    }
}
