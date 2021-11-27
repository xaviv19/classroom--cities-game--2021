package com.drpicox.game.testSteps.player;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

@Component
public class GoToTheOfTheNextPlayerStep extends AbstractPostLineStep {

    private final GameTestView gameTestView;
    private final ScreenStackTestView screenStackTestView;

    public GoToTheOfTheNextPlayerStep(GameTestView gameTestView, ScreenStackTestView screenStackTestView) {
        this.gameTestView = gameTestView;
        this.screenStackTestView = screenStackTestView;
    }

    @Override
    protected String getRegex() {
        return "Go to the \"([^\"]+)\" \"([^\"]+)\" of the next player \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var type = match[1];
        var name = match[2];
        var playerName = match[3];

        gameTestView.nextPlayer(playerName);
        var entity = gameTestView.getGame().getEntityByOwnerNameType(playerName, name, type);
        screenStackTestView.pushScreenName("entity", entity.getId());
    }
}
