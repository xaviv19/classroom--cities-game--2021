package com.drpicox.game.testSteps.components.owneds;

import com.drpicox.game.testSteps.entities.EntityResponse;
import com.drpicox.game.testSteps.entities.EntityTestView;
import com.drpicox.game.testSteps.game.GameTestView;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class OwnedTestView {

    public static Predicate<EntityResponse> byOwner(String ownerName) {
        return e -> e.getOrDefault("owner", "").equals(ownerName);
    }

    private final EntityTestView entityTestView;
    private final GameTestView gameTestView;

    public OwnedTestView(EntityTestView entityTestView, GameTestView gameTestView) {
        this.entityTestView = entityTestView;
        this.gameTestView = gameTestView;
    }

    public String getEntityOwner(String entityId) {
        return gameTestView.getGame().getEntity(entityId).getString("owner");
    }
}
