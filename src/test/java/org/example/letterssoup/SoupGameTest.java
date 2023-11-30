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
}