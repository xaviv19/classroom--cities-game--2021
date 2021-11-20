package com.drpicox.game.entities.cities;

import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EntityVisibleDataGenerator;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.ecs.GameVisibleDataGenerator;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CitiesGameDataGenerator implements GameVisibleDataGenerator {

    private final TypedsController typedsController;
    private final List<EntityVisibleDataGenerator> entityVisibleDataGenerators;

    public CitiesGameDataGenerator(TypedsController typedsController, List<EntityVisibleDataGenerator> entityVisibleDataGenerators) {
        this.typedsController = typedsController;
        this.entityVisibleDataGenerators = entityVisibleDataGenerators;
    }

    @Override
    public void generateVisibleData(GameData data, Player playingPlayer) {
        var components = typedsController.findAllByType("city");
        var publicEntityIds = components.stream().map(c -> c.getEntityId()).collect(Collectors.toList());
        entityVisibleDataGenerators.forEach(g -> g.generateVisibleData(data, playingPlayer, publicEntityIds));
    }
}
