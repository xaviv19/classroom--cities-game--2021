package com.drpicox.game.components.resourcedModifiers;

import com.drpicox.game.components.containeds.ContainedsController;
import com.drpicox.game.components.resourceds.ResourceType;
import com.drpicox.game.components.resourceds.ResourcedsController;
import org.springframework.stereotype.Component;

@Component
public class ResourcedModifiersController {

    private final ResourcedModifiersRepository resourcedModifiersRepository;
    private final ResourcedsController resourcedsController;
    private final ContainedsController containedsController;

    public ResourcedModifiersController(ResourcedModifiersRepository resourcedModifiersRepository, ResourcedsController resourcedsController, ContainedsController containedsController) {
        this.resourcedModifiersRepository = resourcedModifiersRepository;
        this.resourcedsController = resourcedsController;
        this.containedsController = containedsController;
    }

    public void create(String entityId, ResourceType resourceType, int roundIncrementModifier, int maximumModifier) {
        var component = new ResourcedModifier(entityId, resourceType, roundIncrementModifier, maximumModifier);
        resourcedModifiersRepository.save(component);

        var containerId = containedsController.getContainerId(entityId);
        resourcedsController.applyModifier(containerId, resourceType, roundIncrementModifier, maximumModifier);
    }

    public void upgrade(String entityId, int roundIncrementUpgrade, int maximumUpgrade) {
        var resourcedModifier = resourcedModifiersRepository.findById(entityId).get();
        var resourceType = resourcedModifier.getResourceType();
        resourcedModifier.upgrade(roundIncrementUpgrade, maximumUpgrade);
        resourcedModifiersRepository.save(resourcedModifier);

        var containerId = containedsController.getContainerId(entityId);
        resourcedsController.applyModifier(containerId, resourceType, roundIncrementUpgrade, maximumUpgrade);
    }
}
