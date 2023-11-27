package org.example.sudoku;

public class Player {
    private final Card card;

    public Player(Card card) throws IllegalArgumentException {
        if (card == null) throw new IllegalArgumentException();
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public int play(int row, int column, int numberPlayed, boolean isUpdatingPlay) {
        if (!isUpdatingPlay) {
            if (!validatePlayerChoice(row, column)) return -1;
        }

        boolean isRepeatedNumber = checkPlayedNumberIsRepeated(row, column, numberPlayed);
        if (isRepeatedNumber) return -2;

        card.setGameMatrix(row, column, numberPlayed);

        return 0;
    }

    private boolean checkPlayedNumberIsRepeated(int row, int column, int numberPlayed) {
        for (int i = 0; i < card.getGameMatrixSize() + 1; i++) {
            //row
            if (card.getCardMatrix()[row][i] == numberPlayed) return true;
            //column
            if (card.getCardMatrix()[i][column] == numberPlayed) return true;
        }

        return false;
    }

    private boolean validatePlayerChoice(int row, int column) {
        if (row < 0 || column < 0) return false;
        if (row > card.getGameMatrixSize() || column > card.getGameMatrixSize()) return false;
        return card.getInitialCardMaskMatrix()[row][column] == 0;
    }

    // score, money/balance, play/game prizes attribution
}
