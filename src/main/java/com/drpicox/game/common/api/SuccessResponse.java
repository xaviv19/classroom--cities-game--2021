package com.drpicox.game.common.api;

public class SuccessResponse {
    private int status = 200;

    private String message;

    public SuccessResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
