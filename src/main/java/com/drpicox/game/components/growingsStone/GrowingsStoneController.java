package com.drpicox.game.components.growingsStone;


import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

@Component
public class GrowingsStoneController {
    private final GrowingsStoneRepository growingsStoneRepository;

    public GrowingsStoneController(GrowingsStoneRepository growingsStoneRepository) {
        this.growingsStoneRepository = growingsStoneRepository;
    }

    public GrowingStone create(String entityId, Game game) {
        var component = new GrowingStone(entityId, game);
        growingsStoneRepository.save(component);
        return component;
    }

}
