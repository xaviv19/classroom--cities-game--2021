package com.drpicox.game.components.withBuildings;

import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

@Component
public class WithBuildingsController {

    private final WithBuildingsRepository withBuildingsRepository;

    public WithBuildingsController(WithBuildingsRepository withBuildingsRepository) {
        this.withBuildingsRepository = withBuildingsRepository;
    }

    public void create(String entityId, Game game) {
        var component = new WithBuildings(entityId, game);
        withBuildingsRepository.save(component);
    }

    public WithBuildings build(String entityId, String type) {
        var component = withBuildingsRepository.findById(entityId).get();
        component.orderBuild(type);
        withBuildingsRepository.save(component);
        return component;
    }
}
