package com.drpicox.game.entities.buildings.factories;

import com.drpicox.game.components.builder.BuilderFactory;
import com.drpicox.game.components.containeds.ContainedsController;
import com.drpicox.game.components.leveleds.LeveledController;
import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.resourcedModifiers.ResourcedModifiersController;
import com.drpicox.game.components.resourceds.ResourceType;
import com.drpicox.game.components.resourceds.ResourcedsController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EntityIdGenerator;
import org.springframework.stereotype.Component;

@Component
public class WoodDepotFactory implements BuilderFactory {

    private final EntityIdGenerator entityIdGenerator;
    private final ContainedsController containedsController;
    private final NamedsController namedsController;
    private final TypedsController typedsController;
    private final ResourcedsController resourcedsController;
    private final ResourcedModifiersController resourcedModifiersController;
    private final LeveledController leveledController;

    public WoodDepotFactory(EntityIdGenerator entityIdGenerator, ContainedsController containedsController, NamedsController namedsController, TypedsController typedsController, ResourcedsController resourcedsController, ResourcedModifiersController resourcedModifiersController, LeveledController leveledController) {
        this.entityIdGenerator = entityIdGenerator;
        this.containedsController = containedsController;
        this.namedsController = namedsController;
        this.typedsController = typedsController;
        this.resourcedsController = resourcedsController;
        this.resourcedModifiersController = resourcedModifiersController;
        this.leveledController = leveledController;
    }

    @Override
    public String getName() {
        return "Wood depot";
    }

    @Override
    public String getType() {
        return "building";
    }

    @Override
    public String build(String containerId) {
        resourcedsController.consume(containerId, ResourceType.GOLD, 5);

        var entityId = entityIdGenerator.nextEntityId("building");
        containedsController.create(entityId, containerId);
        namedsController.create(entityId, getName());
        typedsController.create(entityId, "building");
        resourcedModifiersController.create(entityId, ResourceType.WOOD, 0, 5);
        leveledController.create(entityId);
        return entityId;
    }
}
