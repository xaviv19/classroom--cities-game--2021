package com.drpicox.game.components.populatedsGrow;

import com.drpicox.game.ecs.EcsComponent;

import javax.persistence.Entity;

@Entity
public class PopulatedGrow extends EcsComponent {
    public PopulatedGrow(String entityId) {
        super(entityId);
    }

    protected PopulatedGrow() {}
}
