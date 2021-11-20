package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

@Component
public class GoBackToTheGameScreenStep extends AbstractPostLineStep {

    private final ScreenStackTestView screenStackTestView;

    public GoBackToTheGameScreenStep(ScreenStackTestView screenStackTestView) {
        this.screenStackTestView = screenStackTestView;
    }

    @Override
    protected String getRegex() {
        return "Go back to the game screen";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        screenStackTestView.pushScreenName("game");
    }
}
