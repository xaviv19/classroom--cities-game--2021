package com.drpicox.game.components.typeds;

import com.drpicox.game.ecs.EntityVisibleDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TypedsEntityVisibleDataGenerator implements EntityVisibleDataGenerator {

    private final TypedsRepository typedsRepository;

    public TypedsEntityVisibleDataGenerator(TypedsRepository typedsRepository) {
        this.typedsRepository = typedsRepository;
    }

    @Override
    public void generateVisibleData(GameData data, Player playingPlayer, List<String> entityIds) {
        var components = typedsRepository.findAllById(entityIds);
        components.forEach(component -> {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "isTyped", true);
            data.putEntityProperty(entityId, "type", component.getType());
        });
    }
}
