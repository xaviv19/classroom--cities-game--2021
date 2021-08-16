package com.drpicox.game.testSteps.newPlayer;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testViews.NewPlayerTestView;
import org.springframework.stereotype.Component;

@Component
public class ClickTheSignupButtonStep extends AbstractPostLineStep {

    private NewPlayerTestView newPlayerTestView;

    public ClickTheSignupButtonStep(NewPlayerTestView newPlayerTestView) {
        this.newPlayerTestView = newPlayerTestView;
    }

    @Override
    protected String getRegex() {
        return "Click the signup button";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        newPlayerTestView.submit();
    }
}
