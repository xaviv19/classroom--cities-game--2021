package com.drpicox.game.testSteps.city;

import com.drpicox.game.cities.api.CityResponse;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.players.api.LoginResponse;
import com.drpicox.game.testPost.SnapshotService;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.helpers.CitiesHelper;
import com.drpicox.game.testSteps.message.MessageTestView;
import com.drpicox.game.testSteps.navigator.NavigableScreen;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import com.drpicox.game.testSteps.player.PlayerTestView;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CityTestView implements NavigableScreen {

    private final GameTestView gameTestView;
    private final NavigatorTestView navigatorTestView;

    public CityTestView(GameTestView gameTestView, NavigatorTestView navigatorTestView) {
        this.gameTestView = gameTestView;
        this.navigatorTestView = navigatorTestView;
    }

    private String newCityName;

    @Override
    public String getScreenName() {
        return "city";
    }

    @Override
    public void show() {
        clear();
    }

    private void clear() {
        newCityName = "";
    }

    public CityResponse getCity() {
        var game = gameTestView.getGame();
        String cityId = navigatorTestView.peekId();

        return CitiesHelper.findById(game, cityId);
    }

    public void enterNewCityName(String newCityName) {
        this.newCityName = newCityName;
    }

    public void submitChangeCityName() {
        var game = gameTestView.getGame();
        String cityId = getCity().getId();

        var data = new HashMap<String, String>();
        data.put("newName", newCityName);

        gameTestView.post("/api/v1/nameds/" + cityId + "/name", data);
    }
}
