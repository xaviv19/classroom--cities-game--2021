package com.drpicox.game.testSteps.loadable;

import com.drpicox.game.testSteps.game.EntityTestView;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class LoadableTestView {

    private final EntityTestView entityTestView;
    private final GameTestView gameTestView;
    private final NavigatorTestView navigatorTestView;

    public LoadableTestView(EntityTestView entityTestView, GameTestView gameTestView, NavigatorTestView navigatorTestView) {
        this.entityTestView = entityTestView;
        this.gameTestView = gameTestView;
        this.navigatorTestView = navigatorTestView;
    }

    private int newLoadUnloadAmount;

    public void enterLoadUnloadAmount(int amount) {
        newLoadUnloadAmount = amount;
    }

    public void submitLoad() {
        String entityId = navigatorTestView.peekId();

        var data = new HashMap<String, String>();
        data.put("newLoadUnloadAmount", "" + newLoadUnloadAmount);

        gameTestView.post("/api/v1/loadables/" + entityId + "/loadUnloadAmount", data);
    }

    public void submitUnload() {
        String entityId = navigatorTestView.peekId();

        var data = new HashMap<String, String>();
        data.put("newLoadUnloadAmount", "-" + newLoadUnloadAmount);

        gameTestView.post("/api/v1/loadables/" + entityId + "/loadUnloadAmount", data);
    }

    public boolean isUnloadRequested() {
        return (Boolean) entityTestView.getEntityProperty("unloadRequested");
    }

    public boolean isLoadRequested() {
        return (Boolean) entityTestView.getEntityProperty("loadRequested");
    }

    public int getLoadUnloadAmount() {
        return ((Double) entityTestView.getEntityProperty("loadUnloadAmount")).intValue();
    }
}
