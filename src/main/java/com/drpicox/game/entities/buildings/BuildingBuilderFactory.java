package com.drpicox.game.entities.buildings;

import com.drpicox.game.components.builder.BuilderController;
import com.drpicox.game.components.containeds.ContainedsController;
import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EntityIdGenerator;
import org.springframework.stereotype.Component;

@Component
public class BuildingBuilderFactory {

    private final EntityIdGenerator entityIdGenerator;
    private final ContainedsController containedsController;
    private final NamedsController namedsController;
    private final TypedsController typedsController;
    private final BuilderController builderController;

    public BuildingBuilderFactory(EntityIdGenerator entityIdGenerator, ContainedsController containedsController, NamedsController namedsController, TypedsController typedsController, BuilderController builderController) {
        this.entityIdGenerator = entityIdGenerator;
        this.containedsController = containedsController;
        this.namedsController = namedsController;
        this.typedsController = typedsController;
        this.builderController = builderController;
    }

    public String buildBuildingBuilder(String containerId) {
        var name = "Builder";
        var entityId = entityIdGenerator.nextEntityId("building");
        containedsController.create(entityId, containerId);
        namedsController.create(entityId, name);
        typedsController.create(entityId, "building");
        builderController.create(entityId, "building");
        return entityId;
    }
}
