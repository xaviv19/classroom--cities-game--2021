package com.drpicox.game.testSteps.components.typeds;

import com.drpicox.game.testSteps.entities.EntityResponse;
import com.drpicox.game.testSteps.entities.EntityTestView;
import com.drpicox.game.testSteps.game.GameTestView;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class TypedTestView {

    public static Predicate<EntityResponse> byType(String type) {
        return e -> e.getOrDefault("type", "").equals(type);
    }

    private final EntityTestView entityTestView;
    private final GameTestView gameTestView;

    public TypedTestView(EntityTestView entityTestView, GameTestView gameTestView) {
        this.entityTestView = entityTestView;
        this.gameTestView = gameTestView;
    }

    public String getType() {
        return getEntityType(entityTestView.getEntityId());
    }

    public String getEntityType(String entityId) {
        return gameTestView.getGame().getEntity(entityId).getString("type");
    }
}
