package com.drpicox.game.components.growingsStone;

import com.drpicox.game.components.growingsStone.GrowingsStoneController;
import com.drpicox.game.components.growingsStone.GrowingsStoneRepository;
import com.drpicox.game.ecs.EcsSystem;
import com.drpicox.game.games.Game;
import com.drpicox.game.components.quantity.QuantityController;
import org.springframework.stereotype.Component;

@Component
public class Sys900_GrowsStone implements EcsSystem {

    private final GrowingsStoneRepository growingsStoneRepository;
    private final GrowingsStoneController growsStoneController;
    private final QuantityController quantityController;

    public Sys900_GrowsStone(GrowingsStoneRepository growingsStoneRepository, GrowingsStoneController growsStoneController, QuantityController quantityController) {
        this.growingsStoneRepository = growingsStoneRepository;
        this.growsStoneController = growsStoneController;
        this.quantityController = quantityController;
    }

    @Override
    public void act(Game game) {
        var cities = growingsStoneRepository.findAllByGame(game);
        cities.forEach(growsStone -> {
            quantityController.increaseQuantity(growsStone.getEntityId(), 25);
        });
    }
}
