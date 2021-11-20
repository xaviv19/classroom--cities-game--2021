package com.drpicox.game.testSteps.player;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.game.GameTestView;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ShouldBeTheCurrentPlayerStep extends AbstractPostLineStep {

    private final GameTestView gameTestView;

    public ShouldBeTheCurrentPlayerStep(GameTestView gameTestView) {
        this.gameTestView = gameTestView;
    }

    @Override
    protected String getRegex() {
        return "\"([^\"]*)\" should be the current player";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var playerName = match[1];
        var game = gameTestView.getGame();

        assertThat(game.getPlayerName()).isEqualTo(playerName);
    }
}
