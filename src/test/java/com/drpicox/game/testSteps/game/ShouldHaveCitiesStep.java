package com.drpicox.game.testSteps.game;

import com.drpicox.game.games.api.CreateGameForm;
import com.drpicox.game.games.api.GamesApi;
import com.drpicox.game.players.api.LoginForm;
import com.drpicox.game.players.api.PlayersApi;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.helpers.CitiesHelper;
import com.drpicox.game.testSteps.listGames.ListGamesTestView;
import com.drpicox.game.testSteps.login.LoginTestView;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ShouldHaveCitiesStep extends AbstractPostLineStep {


    private final GameTestView gameTestView;

    public ShouldHaveCitiesStep(GameTestView gameTestView) {
        this.gameTestView = gameTestView;
    }

    @Override
    protected String getRegex() {
        return "\"([^\"]+)\" should have (\\d+) cities";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var playerName = match[1];
        var count = Integer.parseInt(match[2]);

        var game = gameTestView.getGame();
        var cities = CitiesHelper.findAllByOwner(game, playerName);
        assertThat(cities).hasSize(count);
    }
}
