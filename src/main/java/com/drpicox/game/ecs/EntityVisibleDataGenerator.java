package com.drpicox.game.ecs;

import com.drpicox.game.players.Player;

import java.util.List;

public interface EntityVisibleDataGenerator {
    void generateVisibleData(GameData data, Player playingPlayer, List<String> publicEntityIds);
}
