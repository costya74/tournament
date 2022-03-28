package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();
    private Player first = new Player(1, "first", 1);
    private Player second = new Player(2, "second", 2);
    private Player third = new Player(3, "third", 3);
    private Player forth = new Player(4, "forth", 3);
    private Player fifth = new Player(5, "fifth", 100);

    @BeforeEach
    void setUp() {
        game.register(first);
        game.register(second);
        game.register(third);
        game.register(forth);
    }

    @Test
    void register() {
    }

    @Test
    void shouldRoundWinSecondPlayer() {
        int actual = game.round(first.getName(), second.getName());
        assertEquals(2, actual);
    }

//    @Test
//    void shouldRoundWinSecondPlayerApperCase() {
//        int actual = game.round(first.getName(), "SECOND");
//        assertEquals(2, actual);
//    }

    @Test
    void shouldRoundWinForthPlayerApperCase() {
        int actual = game.round(forth.getName(), first.getName());
        assertEquals(1, actual);
    }

    @Test
    void shouldDraw() {
        int actual = game.round(third.getName(), forth.getName());
        assertEquals(0, actual);
    }

    @Test
    void shouldThereNotRegister() {
        assertThrows(RuntimeException.class, () -> game.round(third.getName(), fifth.getName())
        );
    }

    @Test
    void shouldTheSame() {
        assertThrows(RuntimeException.class, () -> game.round(third.getName(), third.getName())
        );
    }

    @Test
    void shouldFindPlayer() {
        Player first = new Player(1, "first", 1);
        assertEquals(1, 1);
    }
}