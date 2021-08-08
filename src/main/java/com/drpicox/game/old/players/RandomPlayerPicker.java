package com.drpicox.game.old.players;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class RandomPlayerPicker {

    private final Random random;

    public RandomPlayerPicker() {
        this(new Random());
    }

    public RandomPlayerPicker(Random random) {
        this.random = random;
    }

    public Player pickOne(List<Player> players) {
        var size = players.size();
        var index = random.nextInt(size);
        return players.get(index);
    }
}
