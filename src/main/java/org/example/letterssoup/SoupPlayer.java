package org.example.letterssoup;

public class SoupPlayer {
    private final SoupGame soupGame;

    public SoupPlayer(SoupGame soupGame) throws InstantiationException {
        if (soupGame == null) throw new InstantiationException();
        this.soupGame = soupGame;
    }

    public int play(String word) {
        if (word.trim().isEmpty()) throw new IllegalArgumentException("Please provide a word to search.");
        boolean containsWord = soupGame.containsWord(word);
        return containsWord ? 0 : -1; // 0 if contains word and -1 if does not contain word
    }
}
