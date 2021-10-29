package com.drpicox.game.components.growingsGold;

import com.drpicox.game.ecs.EcsSystem;
import com.drpicox.game.games.Game;
import com.drpicox.game.components.quantity.QuantityController;
import org.springframework.stereotype.Component;

@Component
public class Sys900_GrowsGold implements EcsSystem {

    private final GrowingsGoldRepository growingsGoldRepository;
    private final GrowingsGoldController growsGoldController;
    private final QuantityController quantityController;

    public Sys900_GrowsGold(GrowingsGoldRepository growingsGoldRepository, GrowingsGoldController growsGoldController, QuantityController quantityController) {
        this.growingsGoldRepository = growingsGoldRepository;
        this.growsGoldController = growsGoldController;
        this.quantityController = quantityController;
    }

    @Override
    public void act(Game game) {
        var cities = growingsGoldRepository.findAllByGame(game);
        cities.forEach(growsGold -> {
            quantityController.increaseQuantity(growsGold.getEntityId(), 20);
        });
    }
}
