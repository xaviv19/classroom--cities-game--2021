package com.drpicox.game.testSteps.player;

import org.springframework.stereotype.Component;

@Component
public class PlayerTestView {
    private String playerName;
    private String token;

    public void replaceToken(String playerName, String token) {
        this.playerName = playerName;
        this.token = token;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public String getToken() {
        return this.token;
    }
}
