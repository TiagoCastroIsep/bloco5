package org.example.sudoku;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
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
    public void shouldReturnInitialCardMaskMatrix() {
        assertArrayEquals(gameMatrix, sudokuCard.getInitialCardMaskMatrix());
    }
}