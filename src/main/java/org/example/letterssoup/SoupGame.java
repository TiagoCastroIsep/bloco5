package org.example.letterssoup;

import java.util.ArrayList;
import java.util.List;

public class SoupGame {
    private final SoupCard soupCard;

    public SoupGame(SoupCard soupCard) throws InstantiationException {
        if (soupCard == null) throw new InstantiationException();
        this.soupCard = soupCard;
    }

    public boolean containsWord(String word) {
        char[] wordCharactersArray = convertStringToChars(word);
        /** getting mask with 0's and 1's **/
        int[][] hitsMask = getCharHits(soupCard.getSoupMatrix(), wordCharactersArray);
        return seekAllDirections(hitsMask, word.length());
    }

    private boolean seekAllDirections(int[][] hitsMask, int wordLength) {
        if (seekMatrixRowsAndColumns(hitsMask, wordLength)) return true;
        if (seekMatrixPrincipalDiagonal(hitsMask, wordLength)) return true;
        if (seekMatrixSecondDiagonal(hitsMask, wordLength)) return true;
        return false;
    }

    private boolean seekMatrixPrincipalDiagonal(int[][] hitsMask, int wordLength) {
        int rowIndex = hitsMask.length - 1;
        int colIndex = 0;
        while (true) {
            if (rowIndex == -1) {
                int increaseRowIndex = 1;
                while (colIndex != hitsMask.length) {
                    int[] elements = getMaskDiagonal(hitsMask, (rowIndex + increaseRowIndex), ++colIndex);
                    if (getHitsSequenceCount(elements) == wordLength) return true;
                    increaseRowIndex++;
                }
                break;
            }
            int[] elements = getMaskDiagonal(hitsMask, rowIndex, colIndex);
            if (getHitsSequenceCount(elements) == wordLength) return true;
            rowIndex--;
        }
        return false;
    }

    private boolean seekMatrixSecondDiagonal(int[][] hitsMask, int wordLength) {
        int rowIndex = hitsMask.length - 1;
        int colIndex = hitsMask[0].length - 1;
        while (true) {
            if (rowIndex == -1) {
                int increaseRowIndex = 1;
                while (colIndex != -1) {
                    int[] elements = getMaskSecondDiagonal(hitsMask, (rowIndex + increaseRowIndex), --colIndex);
                    if (getHitsSequenceCount(elements) == wordLength) return true;
                    increaseRowIndex++;
                }
                break;
            }
            int[] elements = getMaskSecondDiagonal(hitsMask, rowIndex, colIndex);
            if (getHitsSequenceCount(elements) == wordLength) return true;
            rowIndex--;
        }
        return false;
    }

    private boolean seekMatrixRowsAndColumns(int[][] maskMatrix, int wordLength) {
        for (int i = 0; i < maskMatrix.length; i++) {
            int sequence = 0;
            if (seekRows(maskMatrix, wordLength, i, sequence)) return true;
            if (seekCols(maskMatrix, wordLength, i, sequence)) return true;
        }
        return false;
    }

    private boolean seekRows(int[][] maskMatrix, int wordLength, int i, int sequence) {
        for (int j = 0; j < maskMatrix[0].length; j++) {
            if (maskMatrix[i][j] == 1) sequence += 1;
            if (sequence == wordLength) return true;
        }
        return false;
    }

    private boolean seekCols(int[][] maskMatrix, int wordLength, int i, int sequence) {
        for (int[] matrix : maskMatrix) {
            if (matrix[i] == 1) sequence += 1;
            if (sequence == wordLength) return true;
        }
        return false;
    }

    protected int[] getMaskDiagonal(int[][] maskMatrix, int rowIndex, int colIndex) {
        if (rowIndex >= maskMatrix.length) throw new IndexOutOfBoundsException();
        List<Integer> currDiagonal = new ArrayList<>();
        while (rowIndex < maskMatrix.length && colIndex < maskMatrix[0].length) {
            currDiagonal.add(maskMatrix[rowIndex][colIndex]);
            rowIndex++;
            colIndex++;
        }
        return currDiagonal.stream().mapToInt(Integer::intValue).toArray();
    }

    protected int[] getMaskSecondDiagonal(int[][] maskMatrix, int rowIndex, int colIndex) {
        if (rowIndex >= maskMatrix.length) throw new IndexOutOfBoundsException();
        List<Integer> currDiagonal = new ArrayList<>();
        while (rowIndex < maskMatrix.length && colIndex != -1) {
            currDiagonal.add(maskMatrix[rowIndex][colIndex]);
            rowIndex++;
            colIndex--;
        }
        return currDiagonal.stream().mapToInt(Integer::intValue).toArray();
    }

    private char[] convertStringToChars(String word) {
        char[] wordCharactersArray = new char[word.length()];
        for (int i = 0; i < word.length(); i++) wordCharactersArray[i] = word.charAt(i);
        return wordCharactersArray;
    }

    // TODO: refactor
    private int[][] getCharHits(char[][] soupMatrix, char[] wordCharactersArray) {
        int[][] maskMatrix = new int[soupMatrix.length][soupMatrix[0].length];
        for (int i = 0; i < soupMatrix.length; i++) {
            for (int j = 0; j < soupMatrix[0].length; j++) {
                for (char currChar : wordCharactersArray) {
                    if (soupMatrix[i][j] == currChar) {
                        maskMatrix[i][j] = 1;
                    }
                }
            }
        }
        return maskMatrix;
    }

    private int getHitsSequenceCount(int[] array) {
        int sequence = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) sequence += 1;
        }
        return sequence;
    }
}
