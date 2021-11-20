package com.drpicox.game.components.docks;

import com.drpicox.game.ecs.EntityVisibleDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocksEntityDataGenerator implements EntityVisibleDataGenerator {

    private final DocksRepository docksRepository;

    public DocksEntityDataGenerator(DocksRepository docksRepository) {
        this.docksRepository = docksRepository;
    }

    @Override
    public void generateVisibleData(GameData data, Player playingPlayer, List<String> ownedEntityIds) {
        generateDocksData(data, ownedEntityIds);
    }

    private void generateDocksData(GameData data, List<String> entityIds) {
        var components = docksRepository.findAllById(entityIds);
        components.forEach(component -> {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "isDock", true);
        });
    }
}
