package com.drpicox.game.testSteps.newGame;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;

import org.springframework.stereotype.Component;

@Component
public class ClickTheCreateGameButtonStep extends AbstractPostLineStep {

    private NewGameTestView newGameTestView;

    public ClickTheCreateGameButtonStep(NewGameTestView newGameTestView) {
        this.newGameTestView = newGameTestView;
    }

    @Override
    protected String getRegex() {
        return "Click the create game button";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        newGameTestView.submit();
    }
}
