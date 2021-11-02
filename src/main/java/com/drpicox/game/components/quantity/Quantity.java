package com.drpicox.game.components.quantity;

import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.games.Game;

import javax.persistence.Entity;

@Entity
public class Quantity extends EcsComponent {
    public static final int MAX_QUANTITY = 100000;
    public static final int MIN_QUANTITY = 0;
    private int quantity;

    public Quantity(String entityId, Game game, int initialQuantity) {
        super(entityId, game);
        this.quantity = initialQuantity;
    }

    protected Quantity() {}

    public int getQuantity() {
        return quantity;
    }

    int increaseQuantity(int increment) {
        var prevQuantity = this.quantity;
        this.quantity = Math.min(MAX_QUANTITY, Math.max(0, quantity + increment));
        int unfit = prevQuantity + increment - this.quantity;
        return unfit;
    }

    int decreaseQuantity(int decrease) {
        var prevQuantity = this.quantity;
        this.quantity = Math.max(MIN_QUANTITY, quantity - decrease);
        int unfit = prevQuantity - decrease - this.quantity;
        return unfit;
    }
}
