package org.example.sudoku;

import org.example.EmptyArrayException;

import java.util.Arrays;

public class SudokuCard {
    private final int[][] cardMatrix;
    private final int gameMatrixSize;
    private final int[][] startCard;

    public SudokuCard(int[][] cardMatrix) {
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

//    public int[][] getInitialCardMaskMatrix() {
//        int[][] initialCardMaskMatrix = new int[cardMatrix.length][cardMatrix.length];
//        for (int i = 0; i < gameMatrixSize; i++)
//            for (int j = 0; j < gameMatrixSize; j++)
//                if (cardMatrix[i][j] > 0) {
//                    if (cardMatrix[i][j] == 0) break; //added to kill a mutation
//                    initialCardMaskMatrix[i][j] = cardMatrix[i][j];
//                }
//        return initialCardMaskMatrix;
//    }

    // generate random card matrix method
}
