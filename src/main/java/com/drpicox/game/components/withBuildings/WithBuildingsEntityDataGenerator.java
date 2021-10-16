package com.drpicox.game.components.withBuildings;

import com.drpicox.game.ecs.EntityOwnDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WithBuildingsEntityDataGenerator implements EntityOwnDataGenerator {

    private final WithBuildingsRepository withBuildingsRepository;

    public WithBuildingsEntityDataGenerator(WithBuildingsRepository withBuildingsRepository) {
        this.withBuildingsRepository = withBuildingsRepository;
    }

    @Override
    public void generateOwnData(GameData data, Game game, Player playingPlayer, List<String> entityIds) {
        var components = withBuildingsRepository.findAllById(entityIds);
        components.forEach(component -> {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "buildingHouses", component.getBuildingHouses());
            data.putEntityProperty(entityId, "buildHouse", component.isBuildHouseOrdered());
        });
    }
}
