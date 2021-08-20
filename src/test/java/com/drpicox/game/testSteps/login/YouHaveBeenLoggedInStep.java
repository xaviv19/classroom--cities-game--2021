package com.drpicox.game.testSteps.login;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;

import org.springframework.stereotype.Component;

@Component
public class YouHaveBeenLoggedInStep extends AbstractPostLineStep {

    private LoginTestView loginTestView;

    public YouHaveBeenLoggedInStep(LoginTestView loginTestView) {
        this.loginTestView = loginTestView;
    }

    @Override
    protected String getRegex() {
        return "you have been logged in";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        loginTestView.clear();
        loginTestView.enterPlayerName("leonard");
        loginTestView.enterPassword("tbbt12");
        loginTestView.submit();
    }
}
