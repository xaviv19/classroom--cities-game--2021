package com.drpicox.game.components.resourceds;

import org.springframework.stereotype.Component;

@Component
public class ResourcedsController {

    private final ResourcedsRepository resourcedsRepository;

    public ResourcedsController(ResourcedsRepository resourcedsRepository) {
        this.resourcedsRepository = resourcedsRepository;
    }

    public ResourcedBuilder create(String entityId) {
        var component = new Resourced(entityId);
        resourcedsRepository.save(component);
        return new ResourcedBuilder(component, resourcedsRepository);
    }

    public void transfer(String fromId, String toId, String resource, int loadUnloadAmount) {
        var from = resourcedsRepository.findById(fromId).get();
        var to = resourcedsRepository.findById(toId).get();
        from.transfer(resource, loadUnloadAmount, to);
        resourcedsRepository.save(from);
        resourcedsRepository.save(to);
    }

    public void applyModifier(String entityId, ResourceType resourceType, int roundIncrementModifier, int maximumModifier) {
        var resourced = resourcedsRepository.findById(entityId).get();
        resourced.applyModifier(resourceType, roundIncrementModifier, maximumModifier);
        resourcedsRepository.save(resourced);
    }

    public void consume(String entityId, ResourceType resourceType, int quantity) {
        var resourced = resourcedsRepository.findById(entityId).get();
        resourced.consume(resourceType, quantity);
        resourcedsRepository.save(resourced);
    }

    public void replaceCount(String entityId, ResourceType resourceType, int newValue) {
        var resourced = resourcedsRepository.findById(entityId).get();
        resourced.replaceCount(resourceType, newValue);
        resourcedsRepository.save(resourced);
    }
}
