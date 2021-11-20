package com.drpicox.game.testSteps.typeds;

import com.drpicox.game.testSteps.game.EntityResponse;
import com.drpicox.game.testSteps.game.EntityTestView;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class TypedTestView {

    private final EntityTestView entityTestView;

    public TypedTestView(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    public static Predicate<EntityResponse> byType(String type) {
        return e -> e.getOrDefault("type", "").equals(type);
    }

    public String getType() {
        return getType(entityTestView.getEntityId());
    }

    public String getType(String entityId) {
        return entityTestView.getEntityPropertyString(entityId, "type");
    }
}
