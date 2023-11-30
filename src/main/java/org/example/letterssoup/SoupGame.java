package org.example.letterssoup;

import java.util.Arrays;

public class SoupGame {
    private final SoupCard soupCard;

    public SoupGame(SoupCard soupCard) {
        this.soupCard = soupCard;
    }

    public boolean containsWord(String word) {
        char[] wordCharactersArray = convertStringToChars(word);
        int[][] hitsMask = getCharHits(soupCard.getSoupMatrix(), wordCharactersArray);
        /** if assumed that we can have repeating characters then add extra validation for the sum in the matrix **/
        /** for simplicity, I just assumed that characters are unique
         * otherwise: I'll need to perform a full scan on the matrix for lines, columns and diagonals adding those methods **/
        int hitsCount = getHitsCount(hitsMask);

        return hitsCount == hitsMask.length;
    }

    private char[] convertStringToChars(String word) {
        char[] wordCharactersArray = new char[word.length()];
        for (int i = 0; i < word.length(); i++) wordCharactersArray[i] = word.charAt(i);
        return wordCharactersArray;
    }

    // TODO: refactor method
    private int[][] getCharHits(char[][] soupMatrix, char[] wordCharactersArray) {
        int[][] maskMatrix = new int[soupMatrix.length][soupMatrix[0].length];
        for (int i = 0; i < soupMatrix.length; i++) {
            for (int j = 0; j < soupMatrix.length; j++) {
                for (char currChar : wordCharactersArray) {
                    if (soupMatrix[i][j] == currChar) {
                        maskMatrix[i][j] = 1;
                        break;
                    }
                }
            }
        }

        return maskMatrix;
    }

    private int getHitsCount(int[][] maskMatrix) {
        int sum = 0;
        for (int[] matrix : maskMatrix) {
            sum += Arrays.stream(matrix).sum();
        }
        return sum;
    }
}
