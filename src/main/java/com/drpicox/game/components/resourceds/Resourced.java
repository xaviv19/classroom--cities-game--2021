package com.drpicox.game.components.resourceds;

import com.drpicox.game.ecs.EcsComponent;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

@Entity
public class Resourced extends EcsComponent {
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String, Resource> resourcesMap = new TreeMap<>();

    public Resourced(String entityId) {
        super(entityId);

        Arrays.stream(ResourceType.values()).forEach(t -> replace(t, 0, 0, 0));
    }

    protected Resourced() {
    }

    void replace(ResourceType resourceType, int count, int maximum, int increment) {
        var name = resourceType.getName();
        resourcesMap.put(name, new Resource(count, maximum, increment));
    }

    public void replaceCount(ResourceType resourceType, int newValue) {
        resourcesMap.get(resourceType.getName()).replaceCount(newValue);
    }

    public void replaceMaximum(ResourceType resourceType, int maximum) {
        var name = resourceType.getName();
        var resource = resourcesMap.get(name);
        resource.replaceMaximum(maximum);
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

    public void applyModifier(ResourceType resourceType, int roundIncrementModifier, int maximumModifier) {
        resourcesMap.get(resourceType.getName()).applyModifier(roundIncrementModifier, maximumModifier);
    }

    public void consume(ResourceType resourceType, int quantity) {
        resourcesMap.get(resourceType.getName()).consume(quantity);
    }
}


