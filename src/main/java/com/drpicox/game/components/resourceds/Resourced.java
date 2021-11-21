package com.drpicox.game.components.resourceds;

import com.drpicox.game.ecs.EcsComponent;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

@Entity
public class Resourced extends EcsComponent {
    public static final int MAX_POPULATION = 20;
    private int populationCount;

    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String, Resource> resourcesMap = new TreeMap<>();

    public Resourced(String entityId) {
        super(entityId);
        this.populationCount = 0;

        Arrays.stream(ResourceType.values()).forEach(t -> replace(t, 0, 0, 0));
    }

    protected Resourced() {}

    void replace(ResourceType resourceType, int count, int maximum, int increment) {
        var name = resourceType.name().toLowerCase(Locale.ROOT);
        resourcesMap.put(name, new Resource(count, maximum, increment));
    }

    void increaseAndMaxResources() {
        resourcesMap.values().forEach(resource -> resource.increaseAndMax());
    }

    public Map<String, Resource> getResourcesMap() {
        return resourcesMap;
    }

    public void transfer(String resource, int amount, Resourced toResourced) {
        var from = this.resourcesMap.get(resource);
        var to = toResourced.resourcesMap.get(resource);
        from.transfer(amount, to);
    }
}
