package com.drpicox.game.testSteps.ship;

import com.drpicox.game.ships.api.ShipResponse;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.helpers.ShipsHelper;
import com.drpicox.game.testSteps.navigator.NavigableScreen;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ShipTestView implements NavigableScreen {

    private final GameTestView gameTestView;
    private final NavigatorTestView navigatorTestView;

    public ShipTestView(GameTestView gameTestView, NavigatorTestView navigatorTestView) {
        this.gameTestView = gameTestView;
        this.navigatorTestView = navigatorTestView;
    }

    private int newLoadUnloadAmount;

    @Override
    public String getScreenName() {
        return "ship";
    }

    @Override
    public void show() {
        clear();
    }

    private void clear() {
    }

    public ShipResponse getShip() {
        var game = gameTestView.getGame();
        String shipId = navigatorTestView.peekId();

        return ShipsHelper.findById(game, shipId);
    }

    public void enterLoadUnloadAmount(int amount) {
        newLoadUnloadAmount = amount;
    }

    public void submitLoad() {
        String shipId = getShip().getId();

        var data = new HashMap<String, String>();
        data.put("newLoadUnloadAmount", "" + newLoadUnloadAmount);

        gameTestView.post("/api/v1/ships/" + shipId + "/loadUnloadAmount", data);
    }

    public void submitUnload() {
        String shipId = getShip().getId();

        var data = new HashMap<String, String>();
        data.put("newLoadUnloadAmount", "-" + newLoadUnloadAmount);

        gameTestView.post("/api/v1/ships/" + shipId + "/loadUnloadAmount", data);
    }
}
