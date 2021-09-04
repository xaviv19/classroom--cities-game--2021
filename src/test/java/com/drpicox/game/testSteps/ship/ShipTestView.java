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

    private String newShipName;
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
        newShipName = "";
    }

    public ShipResponse getShip() {
        var game = gameTestView.getGame();
        var shipId = navigatorTestView.peekId();

        return ShipsHelper.findById(game, shipId);
    }

    public void enterNewShipName(String newShipName) {
        this.newShipName = newShipName;
    }

    public void submitChangeShipName() {
        var shipId = getShip().getId();

        var data = new HashMap<String, String>();
        data.put("newShipName", newShipName);

        gameTestView.post("/api/v1/ships/" + shipId + "/name", data);
    }

    public void enterLoadUnloadAmount(int amount) {
        newLoadUnloadAmount = amount;
    }

    public void submitLoad() {
        var shipId = getShip().getId();

        var data = new HashMap<String, String>();
        data.put("newLoadUnloadAmount", "" + newLoadUnloadAmount);

        gameTestView.post("/api/v1/ships/" + shipId + "/loadUnloadAmount", data);
    }

    public void submitUnload() {
        var shipId = getShip().getId();

        var data = new HashMap<String, String>();
        data.put("newLoadUnloadAmount", "-" + newLoadUnloadAmount);

        gameTestView.post("/api/v1/ships/" + shipId + "/loadUnloadAmount", data);
    }
}
