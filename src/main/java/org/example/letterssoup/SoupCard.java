package org.example.letterssoup;

public class SoupCard {
    private final char[][] soupMatrix;

    public SoupCard(char[][] soupMatrix) throws InstantiationException {
        if (soupMatrix == null) throw new InstantiationException();
        if (soupMatrix.length == 0) throw new IllegalArgumentException();
        if (!isRegularMatrix()) throw new IllegalArgumentException();
        this.soupMatrix = getDeepCopy(soupMatrix);
    }

    public boolean isRegularMatrix() {
        int firstRowLength = soupMatrix[0].length;
        for (int i = 1; i < soupMatrix.length; i++) {
            if (soupMatrix[i].length != firstRowLength) return false;
        }
        return true;
    }

    private char[][] getDeepCopy(char[][] matrix) {
        char[][] charCopy = new char[matrix.length][matrix[0].length];
        int index = 0;
        for (char[] row : soupMatrix) {
            charCopy[index] = row;
            index++;
        }

        return charCopy;
    }

    public char[][] getSoupMatrix() {
        return getDeepCopy(soupMatrix);
    }
}
