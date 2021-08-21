package com.drpicox.game.testSteps.listGames;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;

import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ThereShouldBeNoGamesStep extends AbstractPostLineStep {

    private final ListGamesTestView listGamesTestView;

    public ThereShouldBeNoGamesStep(ListGamesTestView listGamesTestView) {
        this.listGamesTestView = listGamesTestView;
    }

    @Override
    protected String getRegex() {
        return "There should be no games";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var games = listGamesTestView.getGames();
        assertThat(games).isEmpty();
    }
}
