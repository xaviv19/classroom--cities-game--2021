package com.drpicox.game.components.loadables;

import com.drpicox.game.components.dockables.DockablesController;
import com.drpicox.game.ecs.EcsSystem;
import com.drpicox.game.games.Game;
import com.drpicox.game.components.populateds.PopulatedsController;
import org.springframework.stereotype.Component;

@Component
public class Sys100_LoadUnload implements EcsSystem {

    private final PopulatedsController populatedsController;
    private final DockablesController dockablesController;
    private final LoadablesController loadablesController;

    public Sys100_LoadUnload(PopulatedsController populatedsController, DockablesController dockablesController, LoadablesController loadablesController) {
        this.populatedsController = populatedsController;
        this.dockablesController = dockablesController;
        this.loadablesController = loadablesController;
    }

    @Override
    public void act(Game game) {
        var loadables = loadablesController.findAllByGame(game);
        loadables.forEach(loadable -> {
            var entityId = loadable.getEntityId();
            var loadUnloadAmount = loadable.getLoadUnloadAmount();
            if (loadUnloadAmount == 0) return;

            var dockId = dockablesController.getDockId(entityId);
            var dockPopulation = populatedsController.getPopulation(dockId);
            var shipPopulation = populatedsController.getPopulation(entityId);

            loadUnloadAmount = Math.min(loadUnloadAmount, dockPopulation);
            var unfit = populatedsController.increasePopulation(entityId, loadUnloadAmount);
            loadablesController.clearLoadUnloadAmount(entityId);

            var delta = -(loadUnloadAmount - unfit);
            populatedsController.increasePopulation(dockId, delta);
        });

    }
}
