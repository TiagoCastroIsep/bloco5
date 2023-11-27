package org.example.sudoku;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private final Card gameMatrix;

    public Game(Card gameMatrix) {
        this.gameMatrix = gameMatrix;
    }

    public boolean isGameOver() {
        Set<Integer> rowNumbers = new HashSet<>();
        Set<Integer> columnNumbers = new HashSet<>();
        runRowsLookup(rowNumbers);
        runColumnsLookup(columnNumbers);

        if (rowNumbers.size() != gameMatrix.getGameMatrixSize() + 1) return false;
        if (!subMatrixNumbersValidated()) return false;
        return columnNumbers.size() == gameMatrix.getGameMatrixSize() + 1;
    }

    private void runRowsLookup(Set<Integer> rowNumbers) {
        int rowNr = 0;
        while (rowNr != gameMatrix.getGameMatrixSize()) {
            for (int i = 0; i < gameMatrix.getGameMatrixSize() + 1; i++) {
                if (gameMatrix.getCardMatrix()[rowNr][i] != 0) {
                    rowNumbers.add(gameMatrix.getCardMatrix()[rowNr][i]);
                }
            }
            rowNr++;
        }
    }

    private void runColumnsLookup(Set<Integer> columnNumbers) {
        int colNr = 0;
        while (colNr != gameMatrix.getGameMatrixSize()) {
            for (int i = 0; i < gameMatrix.getGameMatrixSize() + 1; i++) {
                if (gameMatrix.getCardMatrix()[i][colNr] != 0) {
                    columnNumbers.add(gameMatrix.getCardMatrix()[i][colNr]);
                }
            }
            colNr++;
        }
    }

    private boolean subMatrixNumbersValidated() {
        int subMatrixLength = (int) Math.sqrt(gameMatrix.getGameMatrixSize() + 1);
        int startQuadrantColumn = 0;
        int startQuadrantLine = 0;
        while (startQuadrantColumn <= (gameMatrix.getGameMatrixSize() + 1 - subMatrixLength)) {
            for (int columnsGroup = startQuadrantColumn; columnsGroup <= subMatrixLength; columnsGroup++) {
                Set<Integer> quadrantNumbers = new HashSet<>();
                runLookForEachColumnLineInQuadrant(startQuadrantLine, subMatrixLength, startQuadrantColumn, quadrantNumbers);
                if (quadrantNumbers.size() != gameMatrix.getGameMatrixSize() + 1) return false;
                startQuadrantLine += gameMatrix.getGameMatrixSize() + 1 - subMatrixLength; // +3 for matrix of 9
            }
            startQuadrantColumn += gameMatrix.getGameMatrixSize() + 1 - subMatrixLength; // +3 for matrix of 9
        }

        return true;
    }

    private void runLookForEachColumnLineInQuadrant(int startQuadrantLine, int iterations, int startQuadrantColumn, Set<Integer> quadrantNumbers) {
        for (int line = startQuadrantLine; line <= iterations; line++) {
            if (gameMatrix.getCardMatrix()[line][startQuadrantColumn] != 0) {
                quadrantNumbers.add(gameMatrix.getCardMatrix()[line][startQuadrantColumn]);
            }
        }
    }
}
