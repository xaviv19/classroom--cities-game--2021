package com.drpicox.game.testSteps.components.containeds;

import com.drpicox.game.testSteps.entities.EntityResponse;
import com.drpicox.game.testSteps.entities.EntityTestView;
import com.drpicox.game.testSteps.game.GameTestView;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.drpicox.game.testSteps.components.nameds.NamedTestView.byName;
import static com.drpicox.game.testSteps.components.typeds.TypedTestView.byType;

@Component
public class ContainerTestView {
    private final EntityTestView entityTestView;
    private final GameTestView gameTestView;

    public ContainerTestView(EntityTestView entityTestView, GameTestView gameTestView) {
        this.entityTestView = entityTestView;
        this.gameTestView = gameTestView;
    }

    public Stream<EntityResponse> streamContaineds() {
        var containerId = entityTestView.getEntityId();
        return gameTestView.getGame().streamEntities().filter(byContainer(containerId));
    }

    public EntityResponse getContained(String type, String name) {
        var result = streamContaineds().filter(byType(type)).filter(byName(name)).findAny();
        return result.orElseThrow(() -> errorNoContainedEntitiesWithTypeName(type, name));
    }

    public static final Predicate<EntityResponse> byContainer(String containerId) {
        return (e) -> e.getOrDefault("containerId", "").equals(containerId);
    }

    private AssertionError errorNoContainedEntitiesWithTypeName(String type, String name) {
        return new AssertionError(
                "Expected entities contained by '"+entityTestView.getEntityId()+"' " +
                        "to contain an entity of type '"+ type +"' and name '"+ name +"'.\n" +
                        (streamContaineds().findAny().isEmpty()
                                ? "=> But there was no contained entities"
                                : "But contained entities (id: type-name) are:\n" +
                                streamContaineds().map(c -> c.getId() + ": " + c.getOrDefault("type", "NO_TYPE")+"-"+c.getOrDefault("name", "NO_NAME"))
                        ) + "\n" +
                        "You may want to create/build first the required entity."
        );
    }
}
