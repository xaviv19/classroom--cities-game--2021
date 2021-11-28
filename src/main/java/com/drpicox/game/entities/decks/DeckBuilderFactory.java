package com.drpicox.game.entities.decks;

import com.drpicox.game.components.builder.BuilderController;
import com.drpicox.game.components.containeds.ContainedsController;
import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EntityIdGenerator;
import org.springframework.stereotype.Component;

@Component
public class DeckBuilderFactory {

    private final EntityIdGenerator entityIdGenerator;
    private final ContainedsController containedsController;
    private final NamedsController namedsController;
    private final TypedsController typedsController;
    private final BuilderController builderController;

    public DeckBuilderFactory(EntityIdGenerator entityIdGenerator, ContainedsController containedsController, NamedsController namedsController, TypedsController typedsController, BuilderController builderController) {
        this.entityIdGenerator = entityIdGenerator;
        this.containedsController = containedsController;
        this.namedsController = namedsController;
        this.typedsController = typedsController;
        this.builderController = builderController;
    }

    public String buildBuildingBuilder(String containerId) {
        var name = "Builder";
        var entityId = entityIdGenerator.nextEntityId("deck");
        containedsController.create(entityId, containerId);
        namedsController.create(entityId, name);
        typedsController.create(entityId, "deck");
        builderController.create(entityId, "deck");
        return entityId;
    }
}
