package com.drpicox.game.components.locateds;

import com.drpicox.game.ecs.EntityVisibleDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocatedsEntityVisibleDataGenerator implements EntityVisibleDataGenerator {

    private final LocatedsRepository locatedsRepository;

    public LocatedsEntityVisibleDataGenerator(LocatedsRepository locatedsRepository) {
        this.locatedsRepository = locatedsRepository;
    }

    @Override
    public void generateVisibleData(GameData data, Player playingPlayer, List<String> entityIds) {
        var components = locatedsRepository.findAllById(entityIds);
        components.forEach(component -> {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "isLocated", true);
            data.putEntityProperty(entityId, "location", component.getLocation());
        });
    }
}
