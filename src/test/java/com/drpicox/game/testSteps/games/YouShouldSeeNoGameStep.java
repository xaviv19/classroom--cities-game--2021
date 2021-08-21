package com.drpicox.game.testSteps.games;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static com.google.common.truth.Truth.assertThat;

@Component
public class YouShouldSeeNoGameStep extends AbstractPostLineStep {

    private final GamesTestView gamesTestView;

    public YouShouldSeeNoGameStep(GamesTestView gamesTestView) {
        this.gamesTestView = gamesTestView;
    }

    @Override
    protected String getRegex() {
        return "You should see no game \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var gameName = match[1];

        var games = gamesTestView.getGames();
        var gameNames = games.stream().map(g -> g.getGameName()).collect(Collectors.toList());
        assertThat(gameNames).doesNotContain(gameName);
    }
}
