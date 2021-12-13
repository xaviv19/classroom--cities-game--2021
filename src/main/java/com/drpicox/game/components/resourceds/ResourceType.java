package com.drpicox.game.components.resourceds;

import java.util.Arrays;
import java.util.Optional;

public enum ResourceType {
    POPULATION("population"),
    GOLD("gold"),
    WOOD("wood"),
    STEEL("steel"),
    BANANA("banana"),
    POTATO("potato");

    private String name;

    ResourceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Optional<ResourceType> findByName(String name) {
        return Arrays.stream(values()).filter(r -> r.getName().equals(name)).findAny();
    }
}
