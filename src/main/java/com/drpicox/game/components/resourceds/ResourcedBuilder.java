package com.drpicox.game.components.resourceds;

import java.util.Arrays;

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

    public ResourcedBuilder withMaximums(int maximum) {
        Arrays.stream(ResourceType.values()).forEach(resourceType -> {
            resourced.replaceMaximum(resourceType, maximum);
        });
        resourcedsRepository.save(resourced);
        return this;
    }
}
