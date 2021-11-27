package com.drpicox.game.entities.buildings.factories;

import com.drpicox.game.components.builder.BuilderFactory;
import com.drpicox.game.components.containeds.ContainedsController;
import com.drpicox.game.components.leveleds.LeveledController;
import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.resourcedModifiers.ResourcedModifiersController;
import com.drpicox.game.components.resourceds.ResourceType;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EntityIdGenerator;
import org.springframework.stereotype.Component;

@Component
public class GoldMineFactory implements BuilderFactory {

    private final EntityIdGenerator entityIdGenerator;
    private final ContainedsController containedsController;
    private final NamedsController namedsController;
    private final TypedsController typedsController;
    private final LeveledController leveledController;
    private final ResourcedModifiersController resourcedModifiersController;

    public GoldMineFactory(EntityIdGenerator entityIdGenerator, ContainedsController containedsController, NamedsController namedsController, TypedsController typedsController, LeveledController leveledController, ResourcedModifiersController resourcedModifiersController) {
        this.entityIdGenerator = entityIdGenerator;
        this.containedsController = containedsController;
        this.namedsController = namedsController;
        this.typedsController = typedsController;
        this.leveledController = leveledController;
        this.resourcedModifiersController = resourcedModifiersController;
    }

    @Override
    public String getName() {
        return "Gold mine";
    }

    @Override
    public String getType() {
        return "building";
    }

    @Override
    public String build(String containerId) {
        var entityId = entityIdGenerator.nextEntityId("building");
        containedsController.create(entityId, containerId);
        namedsController.create(entityId, getName());
        typedsController.create(entityId, "building");
        resourcedModifiersController.create(entityId, ResourceType.GOLD, 1, 0);
        leveledController.create(entityId);
        return entityId;
    }
}
