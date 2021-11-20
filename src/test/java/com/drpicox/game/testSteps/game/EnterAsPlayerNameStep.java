package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class EnterAsPlayerNameStep extends AbstractPostLineStep {

    private final GameTestView gameTestView;

    public EnterAsPlayerNameStep(GameTestView gameTestView) {
        this.gameTestView = gameTestView;
    }

    @Override
    protected String getRegex() {
        return "Enter \"([^\"]+)\" as player name";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var playerName = match[1];

        gameTestView.replaceNextPlayerName(playerName);
    }
}
