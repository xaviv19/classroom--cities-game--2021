package com.drpicox.game.games.api;

import com.drpicox.game.common.api.GlobalRestException;

public class ListGamesByPlayerForm {
    private String playerName;

    public String getPlayerName() {
        return playerName;
    }

    public void verify() {
        if (playerName.equals(""))
            throw new GlobalRestException("The friend name should be present");
    }
}
