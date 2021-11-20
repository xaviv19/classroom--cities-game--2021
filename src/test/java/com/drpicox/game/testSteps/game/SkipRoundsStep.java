package com.drpicox.game.testSteps.game;

import com.drpicox.game.games.api.GamesApi;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

@Component
public class SkipRoundsStep extends AbstractPostLineStep {

    private final GamesApi gamesApi;
    private final GameTestView gameTestView;
    private final ScreenStackTestView screenStackTestView;

    public SkipRoundsStep(GamesApi gamesApi, GameTestView gameTestView, ScreenStackTestView screenStackTestView) {
        this.gamesApi = gamesApi;
        this.gameTestView = gameTestView;
        this.screenStackTestView = screenStackTestView;
    }

    @Override
    protected String getRegex() {
        return "Skip (\\d+) rounds";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var count = Integer.parseInt(match[1]);
        var game = gameTestView.getGame();
        var playerName = game.getPlayerName();

        for (var i = 0; i < count - 1; i++) {
            gamesApi.endRound(playerName);
        }

        gameTestView.endTheRound();
        screenStackTestView.pushScreenName("game");
    }
}
