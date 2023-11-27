package org.example.sudoku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    int[][] gameMatrix;
    Card sudokuCard;

    @BeforeEach
    public void setup() {
        gameMatrix = new int[][]{
                {0, 0, 0, 8, 0, 0, 0, 0, 9}, // 9
                {0, 1, 9, 0, 0, 5, 8, 3, 0}, // 8
                {0, 4, 3, 0, 1, 0, 0, 0, 7}, // 7, 5... removed 1 at row 2 col 1 and 7 at row 6 col 1
                {4, 0, 0, 1, 5, 0, 0, 0, 3}, // 1
                {0, 0, 2, 7, 0, 4, 0, 1, 0}, // 1 ...
                {0, 8, 0, 0, 9, 0, 6, 0, 0},
                {0, 7, 0, 0, 0, 6, 3, 0, 0},
                {0, 3, 0, 0, 7, 0, 0, 8, 0},
                {9, 0, 4, 5, 0, 0, 0, 0, 1}
        };

        sudokuCard = new Card(gameMatrix);
    }

    @Test
    public void shouldCreatePlayer() throws IllegalArgumentException {
        Player player = new Player(sudokuCard);
        assertInstanceOf(Card.class, player.getCard());
    }

    @Test
    public void shouldNotUpdateGameForPlayRowLessThanZero() {
        int row = -1;
        int column = 0;
        int numberPlayed = 1;
        boolean isUpdating = false;
        Player player = new Player(sudokuCard);
        int expected = -1;
        assertEquals(expected, player.play(row, column, numberPlayed, isUpdating));
    }

    @Test
    public void shouldNotUpdateGameForPlayRowMoreThanGameSize() {
        int row = sudokuCard.getGameMatrixSize();
        int column = 0;
        int numberPlayed = 1;
        boolean isUpdating = false;
        Player player = new Player(sudokuCard);
        int expected = -1;
        assertEquals(expected, player.play(row, column, numberPlayed, isUpdating));
    }

    @Test
    public void shouldNotUpdateGameForPlayColumnLessThanZero() {
        int row = 0;
        int column = -1;
        int numberPlayed = 1;
        boolean isUpdating = false;
        Player player = new Player(sudokuCard);
        int expected = -1;
        assertEquals(expected, player.play(row, column, numberPlayed, isUpdating));
    }

    @Test
    public void shouldNotUpdateGameForPlayColumnMoreThanGameSize() {
        int row = 0;
        int column = sudokuCard.getGameMatrixSize();
        int numberPlayed = 1;
        boolean isUpdating = false;
        Player player = new Player(sudokuCard);
        int expected = -1;
        assertEquals(expected, player.play(row, column, numberPlayed, isUpdating));
    }

    @Test
    public void shouldNotUpdateGameForPlayWhenHittingCardDefaultValue() {
        int row = 1;
        int column = 1;
        int numberPlayed = 1;
        boolean isUpdating = false;
        Player player = new Player(sudokuCard);
        int expected = -1;
        assertEquals(expected, player.play(row, column, numberPlayed, isUpdating));
    }

    @Test
    public void shouldUpdateGameForValidPlayRow() {
        int row = 0;
        int column = 0;
        int numberPlayed = 1;
        boolean isUpdating = false;
        Player player = new Player(sudokuCard);
        int expected = 0;
        assertEquals(expected, player.play(row, column, numberPlayed, isUpdating));
    }

    @Test
    public void shouldUpdateGameForValidPlayRowUpperLimit() {
        int row = sudokuCard.getGameMatrixSize() - 1;
        int column = 1;
        int numberPlayed = 2;
        boolean isUpdating = false;
        Player player = new Player(sudokuCard);
        int expected = 0;
        assertEquals(expected, player.play(row, column, numberPlayed, isUpdating));
    }

    @Test
    public void shouldUpdateGameForValidPlayColumn() {
        int row = 0;
        int column = 0;
        int numberPlayed = 1;
        boolean isUpdating = false;
        Player player = new Player(sudokuCard);
        int expected = 0;
        assertEquals(expected, player.play(row, column, numberPlayed, isUpdating));
    }

    @Test
    public void shouldUpdateGameForPlayColumnUpperLimit() {
        int row = 1;
        int column = sudokuCard.getGameMatrixSize() - 1;
        int numberPlayed = 2;
        boolean isUpdating = false;
        Player player = new Player(sudokuCard);
        int expected = 0;
        assertEquals(expected, player.play(row, column, numberPlayed, isUpdating));
    }

    @Test
    public void shouldNotUpdateGameForPlayWithRepeatedNumberAtRow() {
        int row = 0;
        int column = 0;
        int numberPlayed = 8;
        boolean isUpdating = false;
        Player player = new Player(sudokuCard);
        int expected = -2;
        assertEquals(expected, player.play(row, column, numberPlayed, isUpdating));
    }

    @Test
    public void shouldNotUpdateGameForPlayWithRepeatedNumberAtColumn() {
        int row = 0;
        int column = 0;
        int numberPlayed = 4;
        boolean isUpdating = false;
        Player player = new Player(sudokuCard);
        int expected = -2;
        assertEquals(expected, player.play(row, column, numberPlayed, isUpdating));
    }

    @Test
    public void shouldUpdateGameForValidPlayAndGetCorrectGameMatrix() {
        int row = 0;
        int column = 0;
        int numberPlayed = 2;
        boolean isUpdating = false;
        Player player = new Player(sudokuCard);
        player.play(row, column, numberPlayed, isUpdating);
        int[][] expected = {
                {2, 0, 0, 8, 0, 0, 0, 0, 9}, // 9
                {0, 1, 9, 0, 0, 5, 8, 3, 0}, // 8
                {0, 4, 3, 0, 1, 0, 0, 0, 7}, // 7, 5... removed 1 at row 2 col 1 and 7 at row 6 col 1
                {4, 0, 0, 1, 5, 0, 0, 0, 3}, // 1
                {0, 0, 2, 7, 0, 4, 0, 1, 0}, // 1 ...
                {0, 8, 0, 0, 9, 0, 6, 0, 0},
                {0, 7, 0, 0, 0, 6, 3, 0, 0},
                {0, 3, 0, 0, 7, 0, 0, 8, 0},
                {9, 0, 4, 5, 0, 0, 0, 0, 1}
        };

        assertArrayEquals(expected, player.getCard().getCardMatrix());
    }
}