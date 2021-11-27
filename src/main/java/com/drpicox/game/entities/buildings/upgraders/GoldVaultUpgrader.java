package com.drpicox.game.entities.buildings.upgraders;

import com.drpicox.game.components.containeds.ContainedsController;
import com.drpicox.game.components.leveleds.LeveledUpgrader;
import com.drpicox.game.components.resourcedModifiers.ResourcedModifiersController;
import com.drpicox.game.components.resourceds.ResourceType;
import com.drpicox.game.components.resourceds.ResourcedsController;
import org.springframework.stereotype.Component;

@Component
public class GoldVaultUpgrader implements LeveledUpgrader {

    private static final int SUCCESS_LEVELS_UP = 1;

    private final ContainedsController containedsController;
    private final ResourcedsController resourcedsController;
    private final ResourcedModifiersController resourcedModifiersController;

    public GoldVaultUpgrader(ContainedsController containedsController, ResourcedsController resourcedsController, ResourcedModifiersController resourcedModifiersController) {
        this.containedsController = containedsController;
        this.resourcedsController = resourcedsController;
        this.resourcedModifiersController = resourcedModifiersController;
    }

    @Override
    public String getName() {
        return "Gold vault";
    }

    @Override
    public int upgrade(String entityId) {
        var containerId = containedsController.getContainerId(entityId);
        resourcedsController.consume(containerId, ResourceType.GOLD, 5);
        resourcedModifiersController.upgrade(entityId, 0, 5);

        return SUCCESS_LEVELS_UP;
    }
}
