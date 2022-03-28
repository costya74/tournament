package ru.netology.domain;

import org.w3c.dom.stylesheets.LinkStyle;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.netology.domain.Player;

public class Game {
    private Map<String, Player> players = new HashMap<>();

    public void register(Player player) {
        this.players.put(player.getName(), player);
    }
// проверяем на регистрацию игроков, если null, значит не числиться, также можно
//    проверять по отдельности как в продукт менелжере
    public int round(String playerName1, String playerName2) {
        // проверяем, что не один и тот же мгрок
        if (playerName1.equals(playerName2)) {
            throw new IllegalArgumentException("same");
        }
        // проверяем, что игрок числиться в зарегистрированных
        var first = players.get(playerName1);      // Player устанавливается само, смотрим подсказки при написании
        var second = players.get(playerName2);
        if (first == null || second == null) {
            throw new RuntimeException("NotRegisteredException");
        }
//        if(playerName1 == null || playerName2 == null)    {
//            throw new IllegalArgumentException("null");
//        }
        // проверку на регистрацию прошли - смотрим результат  по раунду
        var result = first.getStrength() - second.getStrength();
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return 2;
        }
        return 0;
    }

 }


