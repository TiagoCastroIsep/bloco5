package org.example.letterssoup;

public class SoupCard {
    private final char[][] soupMatrix;

    public SoupCard(char[][] soupMatrix) throws InstantiationException {
        if (soupMatrix == null) throw new InstantiationException();
        if (soupMatrix.length == 0) throw new InstantiationException();
        if (!isRegularMatrix(soupMatrix)) throw new InstantiationException();
        this.soupMatrix = getDeepCopy(soupMatrix);
    }

    public boolean isRegularMatrix(char[][] matrix) {
        int firstRowLength = matrix[0].length;
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i].length != firstRowLength) return false;
        }
        return true;
    }

    private char[][] getDeepCopy(char[][] matrix) {
        char[][] charCopy = new char[matrix.length][matrix[0].length];
        int index = 0;
        for (char[] row : matrix) {
            charCopy[index] = row;
            index++;
        }

        return charCopy;
    }

    public char[][] getSoupMatrix() {
        return getDeepCopy(soupMatrix);
    }
}
