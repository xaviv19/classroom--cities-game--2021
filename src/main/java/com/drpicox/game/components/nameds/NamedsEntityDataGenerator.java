package com.drpicox.game.components.nameds;

import com.drpicox.game.ecs.EntityVisibleDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NamedsEntityDataGenerator implements EntityVisibleDataGenerator {

    private final NamedsRepository namedsRepository;

    public NamedsEntityDataGenerator(NamedsRepository namedsRepository) {
        this.namedsRepository = namedsRepository;
    }

    @Override
    public void generateVisibleData(GameData data, Player playingPlayer, List<String> entityIds) {
        var components = namedsRepository.findAllById(entityIds);
        components.forEach(component -> {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "isNamed", true);
            data.putEntityProperty(entityId, "name", component.getName());
        });
    }
}
