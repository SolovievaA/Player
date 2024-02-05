package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void testWhenSecondPlayerWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Vasia", 80);
        Player player2 = new Player(2, "Misha", 190);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Vasia", "Misha");
        int expected = 2;

        Assertions.assertEquals( expected, actual);

    }

    @Test
    public void testWhenFirstPlayerWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Vasia", 180);
        Player player2 = new Player(2, "Misha", 90);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Vasia", "Misha");
        int expected = 1;

        Assertions.assertEquals( expected, actual);

    }

    @Test
    public void testWhenStrenghtsEqual() {
        Game game = new Game();
        Player player1 = new Player(1, "Vasia", 190);
        Player player2 = new Player(2, "Misha", 190);

        game.register(player1);
        game.register(player2);
        int actual = game.round("Vasia", "Misha");
        int expected = 0;

        Assertions.assertEquals( expected, actual);

    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Game game = new Game();
        Player player1 = new Player(1, "Vasia", 80);
        Player player2 = new Player(2, "Misha", 190);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                ()-> game.round("Vasia", "Dania"));

    }
    @Test
    public void testWhenFirstPlayerNotExist() {
        Game game = new Game();
        Player player1 = new Player(1, "Vasia", 80);
        Player player2 = new Player(2, "Misha", 190);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                ()-> game.round("Dania", "Misha"));

    }
}