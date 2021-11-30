package com.drpicox.game.components.loadables;

import com.drpicox.game.ecs.EntityOwnDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoadablesEntityDataGenerator implements EntityOwnDataGenerator {

    private final LoadablesRepository loadablesRepository;

    public LoadablesEntityDataGenerator(LoadablesRepository loadablesRepository) {
        this.loadablesRepository = loadablesRepository;
    }

    @Override
    public void generateOwnData(GameData data, Player playingPlayer, List<String> entityIds) {
        var components = loadablesRepository.findAllById(entityIds);
        for (Loadable component : components) {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "isLoadable", true);
        }
    }
}
