package com.drpicox.game.testSteps.components.nameds;

import com.drpicox.game.testSteps.entities.EntityResponse;
import com.drpicox.game.testSteps.entities.EntityTestView;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class NamedTestView {

    public static Predicate<EntityResponse> byName(String name) {
        return e -> e.getOrDefault("name", "").equals(name);
    }

    public static Function<EntityResponse,String> toName() {
        return e -> (String) e.getOrDefault("name", "-without name-");
    }

    private final EntityTestView entityTestView;
    private final GameTestView gameTestView;
    private final ScreenStackTestView screenStackTestView;

    public NamedTestView(EntityTestView entityTestView, GameTestView gameTestView, ScreenStackTestView screenStackTestView) {
        this.entityTestView = entityTestView;
        this.gameTestView = gameTestView;
        this.screenStackTestView = screenStackTestView;
    }

    public String getName() {
        return entityTestView.getEntity().getString("name");
    }

    public String getEntityName(String entityId) {
        return gameTestView.getGame().getEntity(entityId).getString("name");
    }

    public void enterNewName(String newName) {
        entityTestView.putFormKey("newName", newName);
    }

    public void submitChangeCityName() {
        entityTestView.post("nameds", "name");
    }
}
