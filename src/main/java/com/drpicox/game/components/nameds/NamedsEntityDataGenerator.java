package com.drpicox.game.components.nameds;

import com.drpicox.game.ecs.EntityOwnDataGenerator;
import com.drpicox.game.ecs.EntityVisibleDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NamedsEntityDataGenerator implements EntityVisibleDataGenerator, EntityOwnDataGenerator {

    private final NamedsRepository namedsRepository;

    public NamedsEntityDataGenerator(NamedsRepository namedsRepository) {
        this.namedsRepository = namedsRepository;
    }

    @Override
    public void generateOwnData(GameData data, Player playingPlayer, List<String> entityIds) {
        generateData(data, entityIds);
    }

    @Override
    public void generateVisibleData(GameData data, Player playingPlayer, List<String> entityIds) {
        generateData(data, entityIds);
    }

    private void generateData(GameData data, List<String> entityIds) {
        var components = namedsRepository.findAllById(entityIds);
        components.forEach(component -> {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "isNamed", true);
            data.putEntityProperty(entityId, "name", component.getName());
        });
    }
}
