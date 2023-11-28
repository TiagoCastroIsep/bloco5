package org.example.sudoku;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private final Card gameMatrix;

    public Game(Card gameMatrix) {
        this.gameMatrix = gameMatrix;
    }

    public Card getGameMatrix() {
        return gameMatrix;
    }

    public boolean isGameOver() {
        int rowNr = 0;
        while (rowNr != gameMatrix.getGameMatrixSize()) {
            Set<Integer> rowNumbers = new HashSet<>();
            boolean isComplete = runRowsLookup(rowNumbers, rowNr);
            if (!isComplete) return false;
            rowNr++;
        }

        return true;
    }

    private boolean runRowsLookup(Set<Integer> rowNumbers, int rowNr) {
        for (int i = 0; i < gameMatrix.getGameMatrixSize(); i++) {
            if (gameMatrix.getCardMatrix()[rowNr][i] != 0) {
                rowNumbers.add(gameMatrix.getCardMatrix()[rowNr][i]);
            }
        }

        return rowNumbers.size() == gameMatrix.getGameMatrixSize();
    }
}
