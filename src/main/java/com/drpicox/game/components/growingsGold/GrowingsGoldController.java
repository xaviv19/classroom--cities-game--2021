package com.drpicox.game.components.growingsGold;

import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;



@Component
public class GrowingsGoldController {

    private final GrowingsGoldRepository growingsGoldRepository;

    public GrowingsGoldController(GrowingsGoldRepository growingsGoldRepository) {
        this.growingsGoldRepository = growingsGoldRepository;
    }

    public GrowingGold create(String entityId, Game game) {
        var component = new GrowingGold(entityId, game);
        growingsGoldRepository.save(component);
        return component;
    }

}
