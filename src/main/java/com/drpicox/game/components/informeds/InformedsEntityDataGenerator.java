package com.drpicox.game.components.informeds;

import com.drpicox.game.ecs.EntityOwnDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InformedsEntityDataGenerator implements EntityOwnDataGenerator {

    private final InformedsRepository informedsRepository;

    public InformedsEntityDataGenerator(InformedsRepository informedsRepository) {
        this.informedsRepository = informedsRepository;
    }

    @Override
    public void generateOwnData(GameData data, Game game, Player playingPlayer, List<String> ownedEntityIds) {
        var components = informedsRepository.findAllById(ownedEntityIds);
        for (Informed component : components) {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "wood", 500);
            data.putEntityProperty(entityId, "stone", 500);
            data.putEntityProperty(entityId, "iron", 500);
            data.putEntityProperty(entityId, "tradeResourcesOption", true);
            data.putEntityProperty(entityId, "buildingsOption", true);
            data.putEntityProperty(entityId, "troopsOption", true);
        }
    }
}
