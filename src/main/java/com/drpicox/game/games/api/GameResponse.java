package com.drpicox.game.games.api;

import com.drpicox.game.common.api.ResponseWithMessage;

import java.util.stream.Stream;

public class GameResponse {
    private String gameName;
    private String creatorName;
    private String playerName;
    private String token;

    public GameResponse(String gameName, String creatorName, String playerName, String token) {
        this.gameName = gameName;
        this.creatorName = creatorName;
        this.playerName = playerName;
        this.token = token;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getCreatorName() {
        return this.creatorName;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public String getToken() {
        return this.token;
    }
}
