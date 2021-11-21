package com.drpicox.game.testSteps.components.locateds;

import com.drpicox.game.testSteps.entities.EntityResponse;
import com.drpicox.game.testSteps.entities.EntityTestView;
import com.drpicox.game.testSteps.game.GameTestView;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;
import java.util.stream.Stream;

@Component
public class LocatedTestView {

    public static Predicate<EntityResponse> byLocation(int location) {
        return e -> e.containsKey("location") && e.getInt("location") == location;
    }

    private final EntityTestView entityTestView;
    private final GameTestView gameTestView;

    public LocatedTestView(EntityTestView entityTestView, GameTestView gameTestView) {
        this.entityTestView = entityTestView;
        this.gameTestView = gameTestView;
    }

    public int getLocation() {
        return entityTestView.getEntityPropertyInt("location");
    }

    public Predicate<EntityResponse> byCoLocation() {
        int myLocation = getLocation();
        return byLocation(myLocation);
    }

    public Stream<EntityResponse> streamCoLocateds() {
        return gameTestView.getGame().streamEntities(byCoLocation());
    }
}
