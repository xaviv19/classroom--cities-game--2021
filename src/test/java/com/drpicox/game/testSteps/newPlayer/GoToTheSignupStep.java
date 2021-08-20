package com.drpicox.game.testSteps.newPlayer;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;

import org.springframework.stereotype.Component;

@Component
public class GoToTheSignupStep extends AbstractPostLineStep {

    private NewPlayerTestView newPlayerTestView;

    public GoToTheSignupStep(NewPlayerTestView newPlayerTestView) {
        this.newPlayerTestView = newPlayerTestView;
    }

    @Override
    protected String getRegex() {
        return "Go to the signup";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        newPlayerTestView.clear();
    }
}
