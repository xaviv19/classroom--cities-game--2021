package com.drpicox.game.components.growingsWheat;

import com.drpicox.game.components.quantity.QuantityController;
import com.drpicox.game.ecs.EcsSystem;
import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

@Component
public class Sys900_GrowsWheat implements EcsSystem {

    private final GrowingsWheatRepository growingsWheatRepository;
    private final GrowingsWheatController growsWheatController;
    private final QuantityController quantityController;

    public Sys900_GrowsWheat(GrowingsWheatRepository growingsWheatRepository, GrowingsWheatController growsWheatController, QuantityController quantityController) {
        this.growingsWheatRepository = growingsWheatRepository;
        this.growsWheatController = growsWheatController;
        this.quantityController = quantityController;
    }

    @Override
    public void act(Game game) {
        var cities = growingsWheatRepository.findAllByGame(game);
        cities.forEach(growsWheat -> {
            quantityController.increaseQuantity(growsWheat.getEntityId(), 50);
        });
    }
}
