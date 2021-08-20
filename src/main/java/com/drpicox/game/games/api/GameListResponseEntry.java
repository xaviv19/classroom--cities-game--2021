package com.drpicox.game.games.api;

public class GameListResponseEntry {
    private String playerName;
    private String gameName;

    public GameListResponseEntry(String gameName, String playerName) {
        this.gameName = gameName;
        this.playerName = playerName;
    }

    public String getGameName() {
        return this.gameName;
    }
}
