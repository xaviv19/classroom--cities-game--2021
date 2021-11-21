package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

@Component
public class GoToTheStep extends AbstractPostLineStep {

    private final ScreenStackTestView screenStackTestView;
    private final GameTestView gameTestView;

    public GoToTheStep(ScreenStackTestView screenStackTestView, GameTestView gameTestView) {
        this.screenStackTestView = screenStackTestView;
        this.gameTestView = gameTestView;
    }

    @Override
    protected String getRegex() {
        return "Go to the \"([^\"]+)\" \"([^\"]+)\" \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var owner = match[1];
        var type = match[2];
        var name = match[3];

        var entity = gameTestView.getGame().getEntityByOwnerNameType(owner, name, type);
        screenStackTestView.pushScreenName("entity", entity.getId());
    }
}
