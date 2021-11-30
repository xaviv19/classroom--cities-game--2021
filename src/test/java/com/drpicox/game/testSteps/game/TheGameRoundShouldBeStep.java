package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheGameRoundShouldBeStep extends AbstractPostLineStep {

    private final GameTestView gameTestView;

    public TheGameRoundShouldBeStep(GameTestView gameTestView) {
        this.gameTestView = gameTestView;
    }

    @Override
    protected String getRegex() {
        return "The game round should be (\\d+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var expectedRoundNumber = Integer.parseInt(match[1]);

        var game = gameTestView.getGame();
        var roundNumber = game.getRoundNumber();
        assertThat(roundNumber).isEqualTo(expectedRoundNumber);
    }
}
