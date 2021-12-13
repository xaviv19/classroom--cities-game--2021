package com.drpicox.game.entities.decks.factories;

import com.drpicox.game.components.builder.BuilderFactory;
import com.drpicox.game.components.containeds.ContainedsController;
import com.drpicox.game.components.docks.DocksController;
import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.resourcedModifiers.ResourcedModifiersController;
import com.drpicox.game.components.resourceds.ResourceType;
import com.drpicox.game.components.resourceds.ResourcedsController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EntityIdGenerator;
import org.springframework.stereotype.Component;

@Component
public class PotatoStoreFactory implements BuilderFactory {

    private final EntityIdGenerator entityIdGenerator;
    private final ContainedsController containedsController;
    private final NamedsController namedsController;
    private final TypedsController typedsController;
    private final ResourcedsController resourcedsController;
    private final ResourcedModifiersController resourcedModifiersController;
    private final DocksController docksController;

    public PotatoStoreFactory(EntityIdGenerator entityIdGenerator, ContainedsController containedsController, NamedsController namedsController, TypedsController typedsController, ResourcedsController resourcedsController, ResourcedModifiersController resourcedModifiersController, DocksController docksController) {
        this.entityIdGenerator = entityIdGenerator;
        this.containedsController = containedsController;
        this.namedsController = namedsController;
        this.typedsController = typedsController;
        this.resourcedsController = resourcedsController;
        this.resourcedModifiersController = resourcedModifiersController;
        this.docksController = docksController;
    }

    @Override
    public String getName() {
        return "Potato store";
    }

    @Override
    public String getType() {
        return "deck";
    }

    @Override
    public String build(String containerId) {
        var dockId = docksController.findDockOf(containerId).get().getEntityId();
        resourcedsController.consume(dockId, ResourceType.WOOD, 5);

        var entityId = entityIdGenerator.nextEntityId("deck");
        containedsController.create(entityId, containerId);
        namedsController.create(entityId, getName());
        typedsController.create(entityId, "deck");
        resourcedModifiersController.create(entityId, ResourceType.POTATO, 0, 5);
        return entityId;
    }
}
