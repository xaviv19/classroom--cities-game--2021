package com.drpicox.game.components.loadables;

import com.drpicox.game.ecs.EntityVisibleDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoadablesEntityVisibleDataGenerator implements EntityVisibleDataGenerator {

    private final LoadablesRepository loadablesRepository;

    public LoadablesEntityVisibleDataGenerator(LoadablesRepository loadablesRepository) {
        this.loadablesRepository = loadablesRepository;
    }

    @Override
    public void generateVisibleData(GameData data, Player playingPlayer, List<String> ownedEntityIds) {
        var components = loadablesRepository.findAllById(ownedEntityIds);
        for (var component : components) {
            var entityId = component.getEntityId();
            var loadUnloadAmount = component.getLoadUnloadAmount();
            data.putEntityProperty(entityId, "isLoadable", true);
            data.putEntityProperty(entityId, "loadUnloadAmount", Math.abs(loadUnloadAmount));
            data.putEntityProperty(entityId, "loadRequested", loadUnloadAmount > 0);
            data.putEntityProperty(entityId, "unloadRequested", loadUnloadAmount < 0);
        }
    }
}
