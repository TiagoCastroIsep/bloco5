package org.example.sudoku;

public class Card {
    private final int gameMatrixSize;
    private final int[][] cardMatrix;

    public Card(int[][] cardMatrix) {
        this.cardMatrix = cardMatrix;
        this.gameMatrixSize = cardMatrix.length;
    }

    public int[][] getCardMatrix() {
        return cardMatrix;
    }

    public int getGameMatrixSize() {
        return gameMatrixSize;
    }

    public void setGameMatrix(int row, int column, int numberPlayed) {
        cardMatrix[row][column] = numberPlayed;
    }

    public int[][] getInitialCardMaskMatrix() {
        int[][] initialCardMaskMatrix = new int[cardMatrix.length][cardMatrix.length];
        for (int i = 0; i < gameMatrixSize; i++)
            for (int j = 0; j < gameMatrixSize; j++)
                if (cardMatrix[i][j] > 0) {
                    if (cardMatrix[i][j] == 0) break; //added to kill a mutation
                    initialCardMaskMatrix[i][j] = cardMatrix[i][j];
                }
        return initialCardMaskMatrix;
    }

    // generate random card matrix method
}
