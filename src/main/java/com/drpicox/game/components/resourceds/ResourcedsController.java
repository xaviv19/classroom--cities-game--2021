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

    public int increasePopulation(String entityId, int increment) {
        var populated = resourcedsRepository.findById(entityId).get();
        var result = populated.increasePopulation(increment);
        resourcedsRepository.save(populated);
        return result;
    }

    public int getPopulation(String entityId) {
        var populated = resourcedsRepository.findById(entityId).get();
        return populated.getPopulation();
    }

    public void transfer(String fromId, String toId, String resource, int loadUnloadAmount) {
        var from = resourcedsRepository.findById(fromId).get();
        var to = resourcedsRepository.findById(toId).get();
        from.transfer(resource, loadUnloadAmount, to);
        resourcedsRepository.save(from);
        resourcedsRepository.save(to);
    }
}
