package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.helpers.CitiesHelper;
import com.drpicox.game.testSteps.listGames.ListGamesTestView;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import com.drpicox.game.testSteps.player.PlayerTestView;
import org.springframework.stereotype.Component;

@Component
public class ClickOnTheCityStep extends AbstractPostLineStep {

    private final NavigatorTestView navigatorTestView;
    private final GameTestView gameTestView;

    public ClickOnTheCityStep(NavigatorTestView navigatorTestView, GameTestView gameTestView) {
        this.navigatorTestView = navigatorTestView;
        this.gameTestView = gameTestView;
    }

    @Override
    protected String getRegex() {
        return "Click on the \"([^\"]+)\" city \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var ownerName = match[1];
        var cityName = match[2];

        // TODO: search by type
        var game = gameTestView.getGame();
        var city = CitiesHelper.findByOwnerAndName(game, ownerName, cityName);
        navigatorTestView.pushScreenName("entity", city.getId());
    }
}
