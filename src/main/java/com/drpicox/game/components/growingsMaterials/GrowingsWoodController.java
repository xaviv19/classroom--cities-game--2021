package com.drpicox.game.components.growingsMaterials;

import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;



@Component
public class GrowingsWoodController {

    private final GrowingsWoodRepository growingsWoodRepository;

    public GrowingsWoodController(GrowingsWoodRepository growingsWoodRepository) {
        this.growingsWoodRepository = growingsWoodRepository;
    }

    public GrowingWood create(String entityId, Game game) {
        var component = new GrowingWood(entityId, game);
        growingsWoodRepository.save(component);
        return component;
    }

}
