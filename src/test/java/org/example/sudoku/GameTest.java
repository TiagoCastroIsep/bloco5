package org.example.sudoku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
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
    public void shouldCreateGame() {
        Game game = new Game(sudokuCard);
        assertInstanceOf(Card.class, game.getGameMatrix());
    }

    @Test
    public void shouldReturnTrueForGameOver() {
        int[][] finalGameMatrix = {
                {1, 2, 3, 4},
                {4, 3, 1, 2},
                {2, 1, 4, 3},
                {3, 4, 2, 1}
        };
        Game game = new Game(new Card(finalGameMatrix));
        assertTrue(game.isGameOver());
    }

    @Test
    public void shouldReturnFalseForGameOver() {
        Game game = new Game(sudokuCard);
        assertFalse(game.isGameOver());
    }

    @Test
    public void shouldReturnFalseForGameOverWhenColumnsAreNotFilled() {
        int[][] finalGameMatrix = {
                {1, 2, 3, 4},
                {0, 3, 1, 2},
                {2, 1, 4, 3},
                {3, 4, 2, 1}
        };
        Game game = new Game(new Card(finalGameMatrix));
        assertFalse(game.isGameOver());
    }

    @Test
    public void shouldReturnFalseForGameOverWhenRowIsNotFilled() {
        int[][] finalGameMatrix = {
                {1, 2, 3, 4},
                {0, 0, 0, 0},
                {2, 1, 4, 3},
                {3, 4, 2, 1}
        };
        Game game = new Game(new Card(finalGameMatrix));
        assertFalse(game.isGameOver());
    }

    @Test
    public void shouldReturnFalseForGameOverWhenColumnIsNotFilled() {
        int[][] finalGameMatrix = {
                {1, 0, 3, 4},
                {4, 0, 1, 2},
                {2, 0, 4, 3},
                {3, 0, 2, 1}
        };
        Game game = new Game(new Card(finalGameMatrix));
        assertFalse(game.isGameOver());
    }

    @Test
    public void shouldReturnFalseForGameOverWhenWrongNumbersAreFilledRow() {
        int[][] finalGameMatrix = {
                {1, 2, 4, 4},
                {4, 3, 1, 2},
                {2, 1, 4, 3},
                {3, 4, 2, 1}
        };
        Game game = new Game(new Card(finalGameMatrix));
        assertFalse(game.isGameOver());
    }

    @Test
    public void shouldReturnFalseForGameOverWhenWrongNumbersAreFilledColumn() {
        int[][] finalGameMatrix = {
                {1, 2, 3, 4},
                {4, 3, 1, 2},
                {2, 1, 4, 3},
                {3, 3, 2, 1}
        };
        Game game = new Game(new Card(finalGameMatrix));
        assertFalse(game.isGameOver());
    }
}