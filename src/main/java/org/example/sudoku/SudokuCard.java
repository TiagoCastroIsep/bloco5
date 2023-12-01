package org.example.sudoku;

import org.example.utils.EmptyArrayException;

public class SudokuCard {
    private final int[][] cardMatrix;
    private final int gameMatrixSize;
    private final int[][] startCard;

    public SudokuCard(int[][] cardMatrix) throws InstantiationException {
        if (cardMatrix == null) throw new InstantiationException();
        if (cardMatrix.length == 0) throw new EmptyArrayException();
        this.cardMatrix = getDeepCopy(cardMatrix);
        this.gameMatrixSize = this.cardMatrix.length;
        this.startCard = this.cardMatrix;
    }

    private int[][] getDeepCopy(int[][] matrix) {
        int[][] matrixCopy = new int[matrix.length][matrix[0].length];
        int index = 0;
        for (int[] row : matrix) {
            matrixCopy[index] = row;
            index++;
        }
        return matrixCopy;
    }

    public int[][] getCardMatrix() {
        return getDeepCopy(cardMatrix);
    }

    public int[][] getStartCard() {
        return getDeepCopy(startCard);
    }

    public int getGameMatrixSize() {
        return gameMatrixSize;
    }

    public void setGameMatrix(int row, int column, int numberPlayed) {
        cardMatrix[row][column] = numberPlayed;
    }

    // generate random card matrix method
}
