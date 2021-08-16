package com.drpicox.game.testViews;

import org.springframework.stereotype.Component;

@Component
public class MessageTestView {
    private String message;

    public void replaceMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
