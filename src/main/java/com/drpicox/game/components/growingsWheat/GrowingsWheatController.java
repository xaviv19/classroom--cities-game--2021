package com.drpicox.game.components.growingsWheat;


import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

@Component
public class GrowingsWheatController {
    private final GrowingsWheatRepository growingsWheatRepository;

    public GrowingsWheatController(GrowingsWheatRepository growingsWheatRepository) {
        this.growingsWheatRepository = growingsWheatRepository;
    }

    public GrowingWheat create(String entityId, Game game) {
        var component = new GrowingWheat(entityId, game);
        growingsWheatRepository.save(component);
        return component;
    }
}
