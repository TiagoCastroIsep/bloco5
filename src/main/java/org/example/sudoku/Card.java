package org.example.sudoku;

public class Card {
    private final int gameMatrixSize;
    private final int[][] cardMatrix;

    public Card(int[][] cardMatrix, int gameMatrixSize) {
        this.cardMatrix = cardMatrix;
        this.gameMatrixSize = gameMatrixSize - 1;
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
        for (int i = 0; i < gameMatrixSize + 1; i++)
            for (int j = 0; j < gameMatrixSize + 1; j++)
                if (cardMatrix[i][j] > 0) initialCardMaskMatrix[i][j] = cardMatrix[i][j];
        return initialCardMaskMatrix;
    }

    // generate random card matrix method
}
