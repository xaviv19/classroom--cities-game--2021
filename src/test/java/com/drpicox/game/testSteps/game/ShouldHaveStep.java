package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.drpicox.game.testSteps.components.typeds.TypedTestView.byType;
import static com.drpicox.game.testSteps.components.owneds.OwnedTestView.byOwner;
import static com.google.common.truth.Truth8.assertThat;

@Component
public class ShouldHaveStep extends AbstractPostLineStep {


    private final GameTestView gameTestView;

    public ShouldHaveStep(GameTestView gameTestView) {
        this.gameTestView = gameTestView;
    }

    @Override
    protected String getRegex() {
        return "\"([^\"]+)\" should have (\\d+) \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var playerName = match[1];
        var count = Integer.parseInt(match[2]);
        var type = match[3];

        var cities = gameTestView.getGame().streamEntities(byOwner(playerName).and(byType(type)));
        assertThat(cities).hasSize(count);
    }
}
