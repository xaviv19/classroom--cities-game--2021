package com.drpicox.game.components.containeds;

import com.drpicox.game.ecs.EntityOwnDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContainedsEntityDataGenerator implements EntityOwnDataGenerator {

    private final ContainedsRepository containedsRepository;

    public ContainedsEntityDataGenerator(ContainedsRepository containedsRepository) {
        this.containedsRepository = containedsRepository;
    }

    @Override
    public void generateOwnData(GameData data, Player playingPlayer, List<String> entityIds) {
        var components = containedsRepository.findAllById(entityIds);
        components.forEach(component -> {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "containerId", component.getContainerId());
        });
    }
}
