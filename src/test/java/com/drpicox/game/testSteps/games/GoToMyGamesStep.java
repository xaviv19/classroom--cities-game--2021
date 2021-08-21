package com.drpicox.game.testSteps.games;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class GoToMyGamesStep extends AbstractPostLineStep {

    private final GamesTestView gamesTestView;

    public GoToMyGamesStep(GamesTestView gamesTestView) {
        this.gamesTestView = gamesTestView;
    }

    @Override
    protected String getRegex() {
        return "Go to my games";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        gamesTestView.fetchMyGames();
    }
}
