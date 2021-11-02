package com.drpicox.game.components.quantity;

import com.drpicox.game.components.owneds.Owned;
import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuantityController {

    private final QuantityRepository quantityRepository;

    public QuantityController(QuantityRepository quantityRepository) {
        this.quantityRepository = quantityRepository;
    }

    public int getQuantity(String entityId) {
        return quantityRepository.findById(entityId).get().getQuantity();
    }

    public void create(String entityId, Game game, int initialQuantity) {
        var component = new Quantity(entityId, game, initialQuantity);
        quantityRepository.save(component);
    }

    public Quantity increaseQuantity(String entityId, int increment) {
        var quantity = quantityRepository.findById(entityId).get();
        quantity.increaseQuantity(increment);
        quantityRepository.save(quantity);
        return quantity;
    }

    public Quantity decreaseQuantity(String entityId, int decrease) {
        var quantity = quantityRepository.findById(entityId).get();
        var result = quantity.decreaseQuantity(decrease);
        quantityRepository.save(quantity);
        return quantity;
    }

    /*
        public int getQuantity(String entityId) {
            var quantity = quantityRepository.findById(entityId).get();
            return quantity.getQuantity();
        }
    */
    public List<Quantity> findAllByGameAndQuantity(Game game, int quantity) {
        return quantityRepository.findAllByGameAndQuantity(game, quantity);
    }
}
