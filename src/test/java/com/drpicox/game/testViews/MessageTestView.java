package com.drpicox.game.testViews;

import com.drpicox.game.common.api.GlobalRestException;
import org.springframework.stereotype.Component;

@Component
public class MessageTestView {
    private String message;
    private boolean isError;

    public void reportMessage(String message) {
        this.message = message;
        isError = false;
    }

    public String getMessage() {
        return message;
    }

    public boolean isError() {
        return isError;
    }

    public void reportError(GlobalRestException g) {
        this.message = g.getMessage();
        this.isError = true;
    }
}
