package com.drpicox.game.ecs;

import com.drpicox.game.players.Player;

public interface GameVisibleDataGenerator {
    void generateVisibleData(GameData data, Player playingPlayer);
}
