package com.drpicox.game.testSteps.myGames;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;

import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ThereShouldBeNoGamesStep extends AbstractPostLineStep {

    private final MyGamesTestView myGamesTestView;

    public ThereShouldBeNoGamesStep(MyGamesTestView myGamesTestView) {
        this.myGamesTestView = myGamesTestView;
    }

    @Override
    protected String getRegex() {
        return "There should be no games";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var games = myGamesTestView.getGames();
        assertThat(games).isEmpty();
    }
}
