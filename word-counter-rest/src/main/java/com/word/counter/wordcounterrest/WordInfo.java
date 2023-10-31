package com.word.counter.wordcounterrest;

public record WordInfo(String word, int frequency) implements WordFrequency {

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
