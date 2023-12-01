package org.example.letterssoup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoupGameTest {
    SoupCard soupCard;
    char[][] matrix;
    @BeforeEach
    public void setup() throws InstantiationException {
        matrix = new char[][] {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
        };
        soupCard = new SoupCard(matrix);
    }

    @Test
    public void shouldCreateObject() throws InstantiationException {
        SoupGame soupGame = new SoupGame(soupCard);
    }

    @Test
    public void shouldThrowExceptionWhenRowIndexBiggerThanMatrixLengthPrincipalDiagonal() throws InstantiationException {
        char[][] matrix = new char[][] {
                {'a', 'b', 'a'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
        };
        int[][] maskMatrix = new int[][] {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
        };
        int row = 4;
        int column = 0;
        SoupCard card = new SoupCard(matrix);
        SoupGame game = new SoupGame(card);
        assertThrows(IndexOutOfBoundsException.class, () -> game.getMaskDiagonal(maskMatrix, row, column));
    }

    @Test
    public void shouldThrowExceptionWhenRowIndexEqualsMatrixLengthPrincipalDiagonal() throws InstantiationException {
        char[][] matrix = new char[][] {
                {'a', 'b', 'a'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
        };
        int[][] maskMatrix = new int[][] {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
        };
        int row = 3;
        int column = 0;
        SoupCard card = new SoupCard(matrix);
        SoupGame game = new SoupGame(card);
        assertThrows(IndexOutOfBoundsException.class, () -> game.getMaskDiagonal(maskMatrix, row, column));
    }

    @Test
    public void shouldThrowExceptionWhenRowIndexBiggerThanMatrixLengthSecondDiagonal() throws InstantiationException {
        char[][] matrix = new char[][] {
                {'a', 'b', 'a'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
        };
        int[][] maskMatrix = new int[][] {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
        };
        int row = 4;
        int column = 0;
        SoupCard card = new SoupCard(matrix);
        SoupGame game = new SoupGame(card);
        assertThrows(IndexOutOfBoundsException.class, () -> game.getMaskSecondDiagonal(maskMatrix, row, column));
    }

    @Test
    public void shouldThrowExceptionWhenRowIndexEqualsMatrixLengthSecondDiagonal() throws InstantiationException {
        char[][] matrix = new char[][] {
                {'a', 'b', 'a'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
        };
        int[][] maskMatrix = new int[][] {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
        };
        int row = 3;
        int column = 0;
        SoupCard card = new SoupCard(matrix);
        SoupGame game = new SoupGame(card);
        assertThrows(IndexOutOfBoundsException.class, () -> game.getMaskSecondDiagonal(maskMatrix, row, column));
    }
}