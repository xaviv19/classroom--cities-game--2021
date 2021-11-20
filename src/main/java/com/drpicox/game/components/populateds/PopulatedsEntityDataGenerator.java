package com.drpicox.game.components.populateds;

import com.drpicox.game.components.docks.DocksController;
import com.drpicox.game.ecs.EntityVisibleDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PopulatedsEntityDataGenerator implements EntityVisibleDataGenerator {

    private final PopulatedsRepository populatedsRepository;
    private final DocksController docksController;

    public PopulatedsEntityDataGenerator(PopulatedsRepository populatedsRepository, DocksController docksController) {
        this.populatedsRepository = populatedsRepository;
        this.docksController = docksController;
    }

    @Override
    public void generateVisibleData(GameData data, Player playingPlayer, List<String> entityIds) {
        var components = populatedsRepository.findAllById(entityIds);
        for (Populated component : components) {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "isPopulated", true);
            data.putEntityProperty(entityId, "population", component.getPopulation());
        }
    }
}
