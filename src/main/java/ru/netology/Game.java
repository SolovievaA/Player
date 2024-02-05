package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<Player>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            else if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        else if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }else {
            return 0;
        }
    }
}
