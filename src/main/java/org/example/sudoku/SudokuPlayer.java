package org.example.sudoku;

public class SudokuPlayer {
    private final SudokuCard sudokuCard;

    public SudokuPlayer(SudokuCard sudokuCard) throws IllegalArgumentException {
        if (sudokuCard == null) throw new IllegalArgumentException();
        this.sudokuCard = sudokuCard;
    }

    public SudokuCard getCard() {
        return sudokuCard;
    }

    public int play(int row, int column, int numberPlayed) {
        if (!isCellPlayable(row, column)) return -1;
        if (containsPlayedNumber(row, column, numberPlayed)) return -2;
        sudokuCard.setGameMatrix(row, column, numberPlayed);
        return 0;
    }

    private boolean containsPlayedNumber(int row, int column, int numberPlayed) {
        int index = 0; //changed to while to kill the mutation
        while (index != sudokuCard.getGameMatrixSize()) {
            //row
            if (sudokuCard.getCardMatrix()[row][index] == numberPlayed) return true;
            //column
            if (sudokuCard.getCardMatrix()[index][column] == numberPlayed) return true;
            index++;
        }
        return false;
    }

    private boolean isCellPlayable(int row, int column) {
        if (row < 0 || column < 0) return false;
        if (row >= sudokuCard.getGameMatrixSize() || column >= sudokuCard.getGameMatrixSize()) return false;
        return sudokuCard.getStartCard()[row][column] == 0;
    }

    // score, money/balance, play/game prizes attribution
}
