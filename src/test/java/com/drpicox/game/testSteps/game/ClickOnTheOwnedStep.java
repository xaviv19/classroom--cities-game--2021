package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

import static com.drpicox.game.testSteps.typeds.TypedTestView.byType;
import static com.drpicox.game.testSteps.nameds.NamedTestView.byName;
import static com.drpicox.game.testSteps.owneds.OwnedTestView.byOwner;

@Component
public class ClickOnTheOwnedStep extends AbstractPostLineStep {

    private final ScreenStackTestView screenStackTestView;
    private final GameTestView gameTestView;

    public ClickOnTheOwnedStep(ScreenStackTestView screenStackTestView, GameTestView gameTestView) {
        this.screenStackTestView = screenStackTestView;
        this.gameTestView = gameTestView;
    }

    @Override
    protected String getRegex() {
        return "Click on the \"([^\"]+)\" owned ([a-z]+) \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var ownerName = match[1];
        var type = match[2];
        var name = match[3];

        var game = gameTestView.getGame();
        var entity = gameTestView.findEntity(byType(type).and(byOwner(ownerName)).and(byName(name))).get();

        screenStackTestView.pushScreenName("entity", entity.getId());
    }
}
