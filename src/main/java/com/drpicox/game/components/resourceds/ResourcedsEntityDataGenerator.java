package com.drpicox.game.components.resourceds;

import com.drpicox.game.ecs.EntityVisibleDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResourcedsEntityDataGenerator implements EntityVisibleDataGenerator {

    private final ResourcedsRepository resourcedsRepository;

    public ResourcedsEntityDataGenerator(ResourcedsRepository resourcedsRepository) {
        this.resourcedsRepository = resourcedsRepository;
    }

    @Override
    public void generateVisibleData(GameData data, Player playingPlayer, List<String> entityIds) {
        var components = resourcedsRepository.findAllById(entityIds);
        for (Resourced component : components) {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "isResources", true);
            data.putEntityProperty(entityId, "resources", component.getResourcesMap());
        }
    }
}
