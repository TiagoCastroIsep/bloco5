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
                {'a', 'b', 'c'},
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
    public void shouldReturnZeroWhenFindsWord() {
        String word = "ae";
        int expected = 0;
        assertEquals(expected, soupPlayer.play(word));
    }

    @Test
    public void shouldReturnMinusOneWhenCannotFindWord() {
        String word = "zu";
        int expected = -1;
        assertEquals(expected, soupPlayer.play(word));
    }
}