package com.drpicox.game.testSteps.newPlayer;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;

import org.springframework.stereotype.Component;

@Component
public class SetAsPasswordStep extends AbstractPostLineStep {

    private NewPlayerTestView newPlayerTestView;

    public SetAsPasswordStep(NewPlayerTestView newPlayerTestView) {
        this.newPlayerTestView = newPlayerTestView;
    }

    @Override
    protected String getRegex() {
        return "Set \"([^\"]+)\" as password";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var password = match[1];
        newPlayerTestView.setPassword(password);
    }
}
