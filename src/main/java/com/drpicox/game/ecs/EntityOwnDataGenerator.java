package com.drpicox.game.ecs;

import com.drpicox.game.players.Player;

import java.util.List;

public interface EntityOwnDataGenerator {
    void generateOwnData(GameData data, Player playingPlayer, List<String> publicEntityIds);
}
