package com.drpicox.game.components.resourceds;

public class ResourcedBuilder {

    private final Resourced resourced;
    private final ResourcedsRepository resourcedsRepository;

    ResourcedBuilder(Resourced resourced, ResourcedsRepository resourcedsRepository) {
        this.resourced = resourced;
        this.resourcedsRepository = resourcedsRepository;
    }

    public ResourcedBuilder with(ResourceType resourceType, int count, int maximum, int increment) {
        resourced.replace(resourceType, count, maximum, increment);
        resourcedsRepository.save(resourced);
        return this;
    }
}
