package com.drpicox.game.players.api;

import com.drpicox.game.common.api.GlobalRestException;

public class NewPlayerForm {

    private String playerName;
    private String password;

    public String getPlayerName() {
        return playerName;
    }

    public String getPassword() {
        return password;
    }

    public void verify() {
        if (playerName == null)
            throw new GlobalRestException("You should add a player name");
    }
}
