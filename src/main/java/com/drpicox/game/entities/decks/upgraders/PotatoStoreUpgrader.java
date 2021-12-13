package com.drpicox.game.entities.decks.upgraders;

import com.drpicox.game.components.containeds.ContainedsController;
import com.drpicox.game.components.docks.DocksController;
import com.drpicox.game.components.leveleds.LeveledUpgrader;
import com.drpicox.game.components.resourcedModifiers.ResourcedModifiersController;
import com.drpicox.game.components.resourceds.ResourceType;
import com.drpicox.game.components.resourceds.ResourcedsController;
import org.springframework.stereotype.Component;

@Component
public class PotatoStoreUpgrader implements LeveledUpgrader {

    private static final int SUCCESS_LEVELS_UP = 1;

    private final ContainedsController containedsController;
    private final ResourcedsController resourcedsController;
    private final ResourcedModifiersController resourcedModifiersController;
    private final DocksController docksController;

    public PotatoStoreUpgrader(ContainedsController containedsController, ResourcedsController resourcedsController, ResourcedModifiersController resourcedModifiersController, DocksController docksController) {
        this.containedsController = containedsController;
        this.resourcedsController = resourcedsController;
        this.resourcedModifiersController = resourcedModifiersController;
        this.docksController = docksController;
    }

    @Override
    public String getName() {
        return "Potato store";
    }

    @Override
    public int upgrade(String entityId) {
        var containerId = containedsController.getContainerId(entityId);
        var dockId = docksController.findDockOf(containerId).get().getEntityId();
        resourcedsController.consume(dockId, ResourceType.STEEL, 2);
        resourcedModifiersController.upgrade(entityId, 0, 5);

        return SUCCESS_LEVELS_UP;
    }
}
