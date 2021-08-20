package com.drpicox.game.testSteps.myGames;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static com.google.common.truth.Truth.assertThat;

@Component
public class YouShouldSeeNoGameStep extends AbstractPostLineStep {

    private final MyGamesTestView myGamesTestView;

    public YouShouldSeeNoGameStep(MyGamesTestView myGamesTestView) {
        this.myGamesTestView = myGamesTestView;
    }

    @Override
    protected String getRegex() {
        return "You should see no game \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var gameName = match[1];

        var games = myGamesTestView.getGames();
        var gameNames = games.stream().map(g -> g.getGameName()).collect(Collectors.toList());
        assertThat(gameNames).doesNotContain(gameName);
    }
}
