package com.drpicox.game.components.resourceds;

import com.drpicox.game.ecs.EcsSystem;
import org.springframework.stereotype.Component;

@Component
public class Sys900_IncreaseAndMaxResources implements EcsSystem {

    private final ResourcedsRepository resourcedsRepository;

    public Sys900_IncreaseAndMaxResources(ResourcedsRepository resourcedsRepository) {
        this.resourcedsRepository = resourcedsRepository;
    }

    @Override
    public void act() {
        var components = resourcedsRepository.findAll();
        components.forEach(component -> {
            component.increaseAndMaxResources();
        });
        resourcedsRepository.saveAll(components);
    }
}
