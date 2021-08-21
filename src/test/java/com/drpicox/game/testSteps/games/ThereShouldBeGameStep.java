package com.drpicox.game.testSteps.games;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;

import org.springframework.stereotype.Component;
import static com.google.common.truth.Truth.assertThat;

@Component
public class ThereShouldBeGameStep extends AbstractPostLineStep {

    private final GamesTestView gamesTestView;

    public ThereShouldBeGameStep(GamesTestView gamesTestView) {
        this.gamesTestView = gamesTestView;
    }

    @Override
    protected String getRegex() {
        return "There should be (\\d+) game";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var size = Integer.parseInt(match[1]);
        var games = gamesTestView.getGames();
        assertThat(games).hasSize(size);
    }
}
