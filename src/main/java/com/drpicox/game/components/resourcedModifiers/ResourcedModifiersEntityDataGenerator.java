package com.drpicox.game.components.resourcedModifiers;

import com.drpicox.game.ecs.EntityOwnDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResourcedModifiersEntityDataGenerator implements EntityOwnDataGenerator {

    private final ResourcedModifiersRepository resourcedModifiersRepository;

    public ResourcedModifiersEntityDataGenerator(ResourcedModifiersRepository resourcedModifiersRepository) {
        this.resourcedModifiersRepository = resourcedModifiersRepository;
    }

    @Override
    public void generateOwnData(GameData data, Player playingPlayer, List<String> entityIds) {
        var components = resourcedModifiersRepository.findAllById(entityIds);
        components.forEach(component -> {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "isResourcedModifier", true);
            data.putEntityProperty(entityId, "modifierResourceName", component.getResourceType().getName());
            data.putEntityProperty(entityId, "modifierRoundIncrement", component.getRoundIncrementModifier());
            data.putEntityProperty(entityId, "modifierMaximum", component.getMaximumModifier());
        });
    }
}
