package com.drpicox.game.ecs;

import com.drpicox.game.players.Player;

public interface GameOwnDataGenerator {
    void generateOwnData(GameData data, Player playingPlayer);
}
