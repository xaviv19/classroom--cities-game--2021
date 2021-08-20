package com.drpicox.game.testSteps.newGame;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;

import org.springframework.stereotype.Component;

@Component
public class GoToCreateGameStep extends AbstractPostLineStep {

    private NewGameTestView newGameTestView;

    public GoToCreateGameStep(NewGameTestView newGameTestView) {
        this.newGameTestView = newGameTestView;
    }

    @Override
    protected String getRegex() {
        return "Go to create game";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        newGameTestView.clear();
    }
}
