package org.example.letterssoup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoupPlayerTest {
    SoupCard soupCard;
    SoupGame soupGame;
    SoupPlayer soupPlayer;
    char[][] gameMatrix;

    @BeforeEach
    public void setup() throws InstantiationException {
        gameMatrix = new char[][] {
                {'a', 'b', 'a'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
        };
        soupCard = new SoupCard(gameMatrix);
        soupGame = new SoupGame(soupCard);
        soupPlayer = new SoupPlayer(soupGame);
    }
    @Test
    public void shouldCreatePlayer() throws InstantiationException {
        SoupCard soupCard = new SoupCard(gameMatrix);
        SoupGame soupGame = new SoupGame(soupCard);
        SoupPlayer soupPlayer = new SoupPlayer(soupGame);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionForEmptyWord() {
        String word = " ";
        assertThrows(IllegalArgumentException.class, () -> soupPlayer.play(word));
    }

    @Test
    public void shouldReturnZeroWhenFindsWordRow() {
        String word = "ab";
        int expected = 0;
        assertEquals(expected, soupPlayer.play(word));
    }

    @Test
    public void shouldReturnZeroWhenFindsWordRowWithOneSpaceBetween() throws InstantiationException {
        String word = "aa";
        char[][] gameCard = new char[][] {
                {'a', 'c', 'a'},
                {'d', 'a', 'a'},
                {'g', 'h', 'i'},
        };
        SoupCard card = new SoupCard(gameCard);
        SoupGame game = new SoupGame(card);
        SoupPlayer player = new SoupPlayer(game);
        int expected = 0;
        assertEquals(expected, player.play(word));
    }

    @Test
    public void shouldReturnZeroWhenFindsWordColumn() {
        String word = "fi";
        int expected = 0;
        assertEquals(expected, soupPlayer.play(word));
    }

    @Test
    public void shouldReturnZeroWhenFindsWordColumnWithOneSpaceBetween() throws InstantiationException {
        String word = "ad";
        char[][] gameCard = new char[][] {
                {'a', 'c', 'a'},
                {'g', 'a', 'a'},
                {'d', 'd', 'i'},
        };
        SoupCard card = new SoupCard(gameCard);
        SoupGame game = new SoupGame(card);
        SoupPlayer player = new SoupPlayer(game);
        int expected = 0;
        assertEquals(expected, player.play(word));
    }

    @Test
    public void shouldReturnMinusOneWhenCannotFindWord() {
        String word = "zu";
        int expected = -1;
        assertEquals(expected, soupPlayer.play(word));
    }

    @Test
    public void shouldReturnZeroWhenFindsWordWithRepeatedElementsDiagonalPrincipal() throws InstantiationException {
        String word = "bf";
        char[][] matrix = new char[][] {
                {'a', 'b', 'a'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
        };
        SoupCard card = new SoupCard(matrix);
        SoupGame game = new SoupGame(card);
        SoupPlayer player = new SoupPlayer(game);
        int expected = 0;
        assertEquals(expected, player.play(word));
    }

    @Test
    public void shouldReturnZeroWhenFindsWordWithRepeatedElementsDiagonalPrincipal_2() throws InstantiationException {
        String word = "dh";
        char[][] matrix = new char[][] {
                {'a', 'b', 'a'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
        };
        SoupCard card = new SoupCard(matrix);
        SoupGame game = new SoupGame(card);
        SoupPlayer player = new SoupPlayer(game);
        int expected = 0;
        assertEquals(expected, player.play(word));
    }

    @Test
    public void shouldReturnZeroWhenFindsWordWithRepeatedElementsDiagonalPrincipalWithSpaceBetween() throws InstantiationException {
        String word = "di";
        char[][] matrix = new char[][] {
                {'a', 'b', 'a'},
                {'d', 'd', 'f'},
                {'g', 'h', 'i'},
                {'g', 'h', 'i'},
        };
        SoupCard card = new SoupCard(matrix);
        SoupGame game = new SoupGame(card);
        SoupPlayer player = new SoupPlayer(game);
        int expected = 0;
        assertEquals(expected, player.play(word));
    }

    @Test
    public void shouldReturnZeroWhenFindsWordWithRepeatedElements() throws InstantiationException {
        String word = "ca";
        char[][] matrix = new char[][] {
                {'c', 'b', 'a', 'a'},
                {'d', 'd', 'f', 'b'},
                {'g', 'h', 'a', 'c'},
                {'g', 'h', 'i', 'd'},
                {'g', 'h', 'i', 'e'},
        };
        SoupCard card = new SoupCard(matrix);
        SoupGame game = new SoupGame(card);
        SoupPlayer player = new SoupPlayer(game);
        int expected = 0;
        assertEquals(expected, player.play(word));
    }

    @Test
    public void shouldReturnZeroWhenFindsWordWithRepeatedElementsSecondDiagonal() throws InstantiationException {
        String word = "bd";
        char[][] matrix = new char[][] {
                {'a', 'b', 'a'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
        };
        SoupCard card = new SoupCard(matrix);
        SoupGame game = new SoupGame(card);
        SoupPlayer player = new SoupPlayer(game);
        int expected = 0;
        assertEquals(expected, player.play(word));
    }

    @Test
    public void shouldReturnZeroWhenFindsWordWithRepeatedElementsSecondDiagonal_2() throws InstantiationException {
        String word = "aeg";
        char[][] matrix = new char[][] {
                {'a', 'b', 'a'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
        };
        SoupCard card = new SoupCard(matrix);
        SoupGame game = new SoupGame(card);
        SoupPlayer player = new SoupPlayer(game);
        int expected = 0;
        assertEquals(expected, player.play(word));
    }
}