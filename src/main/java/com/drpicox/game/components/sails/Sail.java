package com.drpicox.game.components.sails;

import com.drpicox.game.ecs.EcsComponent;

import javax.persistence.Entity;

@Entity
public class Sail extends EcsComponent {
    private boolean destinationSail;
    private int destinationLocation;

    public Sail(String entityId) {
        super(entityId);
    }

    protected Sail() {}

    public boolean isDestinationSail() {
        return destinationSail;
    }

    public int getDestinationLocation() {
        return destinationLocation;
    }

    public void orderSail(int destinationLocation) {
        this.destinationLocation = destinationLocation;
        this.destinationSail = true;
    }

    public void orderHalt() {
        this.destinationSail = false;
    }

    public void halt() {
        this.destinationSail = false;
    }
}
