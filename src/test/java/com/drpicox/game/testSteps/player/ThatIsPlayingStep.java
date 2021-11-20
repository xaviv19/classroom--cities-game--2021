package com.drpicox.game.testSteps.player;

import com.drpicox.game.games.GamesController;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class ThatIsPlayingStep extends AbstractPostLineStep {

    private final GamesController gamesController;

    public ThatIsPlayingStep(GamesController gamesController) {
        this.gamesController = gamesController;
    }

    @Override
    protected String getRegex() {
        return "that \"([^\"]+)\" is playing";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var playerName = match[1];

        gamesController.joinPlayer(playerName);
    }
}
