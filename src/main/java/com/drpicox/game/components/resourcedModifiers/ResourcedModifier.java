package com.drpicox.game.components.resourcedModifiers;

import com.drpicox.game.components.resourceds.ResourceType;
import com.drpicox.game.ecs.EcsComponent;

import javax.persistence.Entity;

@Entity
public class ResourcedModifier extends EcsComponent {
    private ResourceType resourceType;
    private int roundIncrementModifier;
    private int maximumModifier;

    public ResourcedModifier(String entityId, ResourceType resourceType, int roundIncrementModifier, int maximumModifier) {
        super(entityId);
        this.resourceType = resourceType;
        this.roundIncrementModifier = roundIncrementModifier;
        this.maximumModifier = maximumModifier;
    }

    protected ResourcedModifier() {}

    public ResourceType getResourceType() {
        return resourceType;
    }

    public int getRoundIncrementModifier() {
        return roundIncrementModifier;
    }

    public int getMaximumModifier() {
        return maximumModifier;
    }

    public void upgrade(int roundIncrementUpgrade, int maximumUpgrade) {
        this.roundIncrementModifier += roundIncrementUpgrade;
        this.maximumModifier += maximumUpgrade;
    }
}
