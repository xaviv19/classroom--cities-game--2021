package com.drpicox.game.testSteps.login;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;

import org.springframework.stereotype.Component;

@Component
public class HasBeenLoggedInStep extends AbstractPostLineStep {

    private LoginTestView loginTestView;

    public HasBeenLoggedInStep(LoginTestView loginTestView) {
        this.loginTestView = loginTestView;
    }

    @Override
    protected String getRegex() {
        return "\"([^\"]+)\" has been logged in";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var playerName = match[1];
        var password = "tbbt12";

        loginTestView.clear();
        loginTestView.enterPlayerName(playerName);
        loginTestView.enterPassword(password);
        loginTestView.submit();
    }
}
