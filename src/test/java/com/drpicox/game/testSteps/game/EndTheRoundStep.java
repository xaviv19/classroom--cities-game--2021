package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

@Component
public class EndTheRoundStep extends AbstractPostLineStep {

    private final GameTestView gameTestView;
    private final ScreenStackTestView screenStackTestView;

    public EndTheRoundStep(GameTestView gameTestView, ScreenStackTestView screenStackTestView) {
        this.gameTestView = gameTestView;
        this.screenStackTestView = screenStackTestView;
    }

    @Override
    protected String getRegex() {
        return "End the round";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        gameTestView.endTheRound();
        screenStackTestView.pushScreenName("game");
    }
}
