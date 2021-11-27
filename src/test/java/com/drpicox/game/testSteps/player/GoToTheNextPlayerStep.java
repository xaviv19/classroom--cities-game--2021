package com.drpicox.game.testSteps.player;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

@Component
public class GoToTheNextPlayerStep extends AbstractPostLineStep {

    private final GameTestView gameTestView;
    private final ScreenStackTestView screenStackTestView;

    public GoToTheNextPlayerStep(GameTestView gameTestView, ScreenStackTestView screenStackTestView) {
        this.gameTestView = gameTestView;
        this.screenStackTestView = screenStackTestView;
    }

    @Override
    protected String getRegex() {
        return "Go to the next player \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var playerName = match[1];

        gameTestView.nextPlayer(playerName);
        screenStackTestView.pushScreenName("game");
    }
}
