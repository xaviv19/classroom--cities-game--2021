package com.drpicox.game.testSteps.player;

import org.springframework.stereotype.Component;

@Component
public class PlayerTestView {
    private String playerName;
    private String token;
    private String friendName = "";

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

    public void enterFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendName() {
        return this.friendName;
    }
}
