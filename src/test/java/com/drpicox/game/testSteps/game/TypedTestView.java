package com.drpicox.game.testSteps.game;

import com.drpicox.game.ecs.EntityResponse;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class TypedTestView {

    private final EntityTestView entityTestView;

    public TypedTestView(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    public static Predicate<EntityResponse> byEntityType(String entityType) {
        return e -> e.getOrDefault("entityType", "").equals(entityType);
    }

    public String getEntityType() {
        return (String) entityTestView.getEntityProperty("entityType");
    }
}
