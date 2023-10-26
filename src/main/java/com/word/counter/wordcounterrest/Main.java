package com.word.counter.wordcounterrest;

public class Main {
    public static void main(String[] args) {
        String text = "Koffie is mijn favoriete drankje. Testing is nodig. Zwarte Koffie, Straffe Koffie, KOFFIE met melk, Cappucino. Eigenlijk vind ik het allemaal wel lekker als drankje of als toetje.";
        System.out.printf("The Frequency of 'drankje' is: " + new WordCounter().calculateFrequencyForWord(text, "koffie") + "\n");
        System.out.printf("The highest Frequency in the text is: " + new WordCounter().calculateHighestFrequency(text) + "\n");
        StringBuilder msg = new StringBuilder();
        for (WordFrequency word: new WordCounter().calculateMostFrequentNWords(text, 3)) {
            msg.append(word.getWord()).append(" ").append(word.getFrequency()).append("\r");
        }
        System.out.println("The top 3 words: " + msg.toString());
    }
}