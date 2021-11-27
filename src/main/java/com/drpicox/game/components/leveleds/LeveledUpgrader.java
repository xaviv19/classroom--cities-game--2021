package com.drpicox.game.components.leveleds;

public interface LeveledUpgrader {
    String getName();
    int upgrade(String entityId);
}
