package com.drpicox.game.components.loadables;

import com.drpicox.game.ecs.EcsSystem;
import com.drpicox.game.components.resourceds.ResourcedsController;
import org.springframework.stereotype.Component;

@Component
public class Sys100_LoadUnload implements EcsSystem {

    private final ResourcedsController resourcedsController;
    private final LoadablesRepository loadablesRepository;

    public Sys100_LoadUnload(ResourcedsController resourcedsController, LoadablesRepository loadablesRepository) {
        this.resourcedsController = resourcedsController;
        this.loadablesRepository = loadablesRepository;
    }

    @Override
    public void act() {
        var loadables = loadablesRepository.findAll();
        loadables.forEach(loadable -> {
            var entityId = loadable.getEntityId();
            var loadUnloadAmount = loadable.getLoadUnloadAmount();
            if (loadUnloadAmount == 0) return;

            var targetId = loadable.getSourceEntityId();
            var dockPopulation = resourcedsController.getPopulation(targetId);

            loadUnloadAmount = Math.min(loadUnloadAmount, dockPopulation);
            var unfit = resourcedsController.increasePopulation(entityId, loadUnloadAmount);
            loadable.clearLoadUnloadOrder();
            loadablesRepository.save(loadable);

            var delta = -(loadUnloadAmount - unfit);
            resourcedsController.increasePopulation(targetId, delta);
        });

    }
}
