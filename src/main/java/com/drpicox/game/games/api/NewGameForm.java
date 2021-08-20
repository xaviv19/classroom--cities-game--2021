package com.drpicox.game.games.api;

import com.drpicox.game.common.api.GlobalRestException;

public class NewGameForm {
    private String gameName;
    private String token;

    public String getGameName() {
        return gameName;
    }

    public String getToken() {
        return token;
    }

    public void verify() {
        if (gameName.equals(""))
            throw new GlobalRestException("Game name should be present");
    }
}
