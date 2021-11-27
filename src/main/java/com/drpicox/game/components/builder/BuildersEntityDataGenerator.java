package com.drpicox.game.components.builder;

import com.drpicox.game.ecs.EntityOwnDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuildersEntityDataGenerator implements EntityOwnDataGenerator {

    private final BuildersRepository buildersRepository;

    public BuildersEntityDataGenerator(BuildersRepository buildersRepository) {
        this.buildersRepository = buildersRepository;
    }

    @Override
    public void generateOwnData(GameData data, Player playingPlayer, List<String> entityIds) {
        var components = buildersRepository.findAllById(entityIds);
        components.forEach(component -> {
            var entityId = component.getEntityId();
            data.putEntityProperty(entityId, "isBuilder", true);
            data.putEntityProperty(entityId, "buildeableBuildings", component.getBuildeableBuildings());
        });
    }
}
