package com.drpicox.game.testSteps.games;

import com.drpicox.game.games.api.GameListResponseEntry;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.truth.Truth.assertThat;

@Component
public class YouShouldSeeTheGameStep extends AbstractPostLineStep {

    private final GamesTestView gamesTestView;

    public YouShouldSeeTheGameStep(GamesTestView gamesTestView) {
        this.gamesTestView = gamesTestView;
    }

    @Override
    protected String getRegex() {
        return "You should see the game \"([^\"]+)\"( and creator \"([^\"]+)\")?";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var gameName = match[1];
        var creatorName = match[3];

        var games = gamesTestView.getGames();
        if (creatorName == null) runWithoutCreator(games, gameName);
        else runWithCreator(games, gameName, creatorName);
    }

    private void runWithoutCreator(List<GameListResponseEntry> games, String gameName) {
        var gameNames = games.stream().map(g -> g.getGameName()).collect(Collectors.toList());
        assertThat(gameNames).contains(gameName);
    }

    private void runWithCreator(List<GameListResponseEntry> games, String gameName, String creatorName) {
        var pairs = games.stream()
                .map(g -> g.getGameName() + "#" + g.getCreatorName())
                .collect(Collectors.toList());

        assertThat(pairs).contains(gameName + "#" + creatorName);
    }

}
