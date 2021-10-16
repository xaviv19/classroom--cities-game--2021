package com.drpicox.game.components.withBuildings;

import com.drpicox.game.components.sails.Sail;
import com.drpicox.game.ecs.EcsSystem;
import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

@Component
public class Sys300_BuildBuildings implements EcsSystem {

    private final WithBuildingsRepository withBuildingsRepository;

    public Sys300_BuildBuildings(WithBuildingsRepository withBuildingsRepository) {
        this.withBuildingsRepository = withBuildingsRepository;
    }

    @Override
    public void act(Game game) {
        var components = withBuildingsRepository.findAllByGameAndOrderBuildNotNull(game);
        components.forEach(component -> {
            component.build();
            withBuildingsRepository.save(component);
        });
    }

}
