package com.drpicox.game.components.growingsIron;

import com.drpicox.game.ecs.EcsSystem;
import com.drpicox.game.games.Game;
import com.drpicox.game.components.quantity.QuantityController;
import org.springframework.stereotype.Component;

@Component
public class Sys900_GrowsIron implements EcsSystem {

    private final GrowingsIronRepository growingsIronRepository;
    private final GrowingsIronController growsIronController;
    private final QuantityController quantityController;

    public Sys900_GrowsIron(GrowingsIronRepository growingsIronRepository, GrowingsIronController growsIronController, QuantityController quantityController) {
        this.growingsIronRepository = growingsIronRepository;
        this.growsIronController = growsIronController;
        this.quantityController = quantityController;
    }

    @Override
    public void act(Game game) {
        var cities = growingsIronRepository.findAllByGame(game);
        cities.forEach(growsIron -> {
            quantityController.increaseQuantity(growsIron.getEntityId(), 20);
        });
    }
}
