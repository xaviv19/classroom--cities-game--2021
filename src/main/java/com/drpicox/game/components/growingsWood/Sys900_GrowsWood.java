package com.drpicox.game.components.growingsWood;

import com.drpicox.game.ecs.EcsSystem;
import com.drpicox.game.games.Game;
import com.drpicox.game.components.quantity.QuantityController;
import org.springframework.stereotype.Component;

@Component
public class Sys900_GrowsWood implements EcsSystem {

    private final GrowingsWoodRepository growingsWoodRepository;
    private final GrowingsWoodController growsWoodController;
    private final QuantityController quantityController;

    public Sys900_GrowsWood(GrowingsWoodRepository growingsWoodRepository, GrowingsWoodController growsWoodController, QuantityController quantityController) {
        this.growingsWoodRepository = growingsWoodRepository;
        this.growsWoodController = growsWoodController;
        this.quantityController = quantityController;
    }

    @Override
    public void act(Game game) {
        var cities = growingsWoodRepository.findAllByGame(game);
        cities.forEach(growsWood -> {
            quantityController.increaseQuantity(growsWood.getEntityId(), 35);
        });
    }
}
