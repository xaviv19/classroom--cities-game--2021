package com.drpicox.game.testSteps.components.resourceds;

import com.drpicox.game.components.resourceds.ResourceType;
import com.drpicox.game.testSteps.entities.EntityTestView;
import com.drpicox.game.testSteps.game.GameTestView;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ResourcedTestView {

    private final GameTestView gameTestView;
    private final EntityTestView entityTestView;

    public ResourcedTestView(GameTestView gameTestView, EntityTestView entityTestView) {
        this.gameTestView = gameTestView;
        this.entityTestView = entityTestView;
    }

    public int getResourceCount(String resource) {
        return this.getResourceCount(entityTestView.getEntityId(), resource);
    }

    public int getResourceCount(String entityId, String resourceName) {
        Map<String, Double> resource = getResource(entityId, resourceName);
        var count = resource.get("count");
        return count.intValue();
    }

    public int getResourceMaximum(String resource) {
        var entityId = entityTestView.getEntityId();
        return this.getResourceMaximum(entityTestView.getEntityId(), resource);
    }

    public int getResourceMaximum(String entityId, String resourceName) {
        Map<String, Double> resource = getResource(entityId, resourceName);
        var maximum = resource.get("maximum");
        return maximum.intValue();
    }

    public int getResourceRoundIncrement(String resourceName) {
        var entityId = entityTestView.getEntityId();
        Map<String, Double> resource = getResource(entityId, resourceName);
        var count = resource.get("roundIncrement");
        return count.intValue();
    }

    private Map<String, Double> getResource(String entityId, String resourceName) {
        var entity = gameTestView.getGame().getEntity(entityId);
        var resources = (Map<String, Map<String,Double>>) entity.get("resources", Map.class);
        var resource = resources.get(resourceName);
        if (resource == null) throw errorNoResourceForResourceName(entityId, resourceName, resources);
        return resource;
    }

    private AssertionError errorNoResourceForResourceName(String entityId, String resourceName, Map<String, Map<String, Double>> resources) {
        return new AssertionError(
                "Entity '"+ entityId +"' has no resource '"+ resourceName +"'; " +
                        "Available resources are:\n- " + resources.keySet().stream().collect(Collectors.joining("\n- ")) +
                        "\nYou may want to add the resource type to the "+ ResourceType.class.getName() +" enum."
        );
    }
}
