package com.drpicox.game.testSteps.loadable;

import com.drpicox.game.loadable.LoadableResponse;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class LoadableTestView {

    private final GameTestView gameTestView;
    private final NavigatorTestView navigatorTestView;

    public LoadableTestView(GameTestView gameTestView, NavigatorTestView navigatorTestView) {
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

    public LoadableResponse getLoadable() {
        String entityId = navigatorTestView.peekId();
        var entity = gameTestView.getGame().getEntityResponse(entityId);
        return entity.getComponent(LoadableResponse.class).get();
    }
}
