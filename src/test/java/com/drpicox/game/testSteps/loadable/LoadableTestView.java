package com.drpicox.game.testSteps.loadable;

import com.drpicox.game.ecs.EntityResponse;
import com.drpicox.game.testSteps.game.EntityTestView;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.locateds.LocatedTestView;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.Predicate;

import static com.drpicox.game.testSteps.docks.DockTestView.isDock;
import static com.drpicox.game.testSteps.game.TypedTestView.byType;

@Component
public class LoadableTestView {

    private final EntityTestView entityTestView;
    private final GameTestView gameTestView;
    private final NavigatorTestView navigatorTestView;
    private final LocatedTestView locatedTestView;

    public LoadableTestView(EntityTestView entityTestView, GameTestView gameTestView, NavigatorTestView navigatorTestView, LocatedTestView locatedTestView) {
        this.entityTestView = entityTestView;
        this.gameTestView = gameTestView;
        this.navigatorTestView = navigatorTestView;
        this.locatedTestView = locatedTestView;
    }

    private int newLoadUnloadAmount;

    public void enterLoadUnloadAmount(int amount) {
        newLoadUnloadAmount = amount;
    }

    public void submitLoad() {
        submitUnloadUnload(newLoadUnloadAmount);
    }

    public void submitUnload() {
        submitUnloadUnload(-newLoadUnloadAmount);
    }

    private void submitUnloadUnload(int loadUnloadAmount) {
        var entityId = navigatorTestView.peekId();
        var sourceEntityId = getSourceEntityId();

        var data = new HashMap<String, Object>();
        data.put("newLoadUnloadAmount", loadUnloadAmount);
        data.put("sourceEntityId", sourceEntityId);

        gameTestView.post("/api/v1/loadables/" + entityId + "/loadUnloadAmount", data);
    }

    private String getSourceEntityId() {
        return gameTestView.streamEntities(isDock().and(locatedTestView.byCoLocation()))
                .findFirst().get().getId();
    }

    public boolean isUnloadRequested() {
        return entityTestView.getEntityPropertyBoolean("unloadRequested");
    }

    public boolean isLoadRequested() {
        return entityTestView.getEntityPropertyBoolean("loadRequested");
    }

    public int getLoadUnloadAmount() {
        return entityTestView.getEntityPropertyInt("loadUnloadAmount");
    }
}
