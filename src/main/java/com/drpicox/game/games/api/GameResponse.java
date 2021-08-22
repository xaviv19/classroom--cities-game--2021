package com.drpicox.game.games.api;

import com.drpicox.game.common.api.ResponseWithMessage;

import java.util.stream.Stream;

public class GameResponse {
    private String gameName;
    private String creatorName;

    public GameResponse(String gameName, String creatorName) {
        this.gameName = gameName;
        this.creatorName = creatorName;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getCreatorName() {
        return this.creatorName;
    }
}
