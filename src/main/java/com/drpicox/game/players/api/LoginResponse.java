package com.drpicox.game.players.api;

public class LoginResponse {
    private String playerName;
    private String token;
    private String message;

    public LoginResponse(String playerName, String token, String message) {
        this.playerName = playerName;
        this.token = token;
        this.message = message;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }
}
