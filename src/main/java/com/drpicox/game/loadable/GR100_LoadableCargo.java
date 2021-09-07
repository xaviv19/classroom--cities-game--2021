package com.drpicox.game.loadable;

import com.drpicox.game.cities.CityController;
import com.drpicox.game.dockables.DockablesController;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameRounder;
import com.drpicox.game.loadable.LoadablesController;
import com.drpicox.game.populateds.PopulatedsController;
import org.springframework.stereotype.Component;

@Component
public class GR100_LoadableCargo implements GameRounder {

    private final PopulatedsController populatedsController;
    private final DockablesController dockablesController;
    private final LoadablesController loadablesController;

    public GR100_LoadableCargo(PopulatedsController populatedsController, DockablesController dockablesController, LoadablesController loadablesController) {
        this.populatedsController = populatedsController;
        this.dockablesController = dockablesController;
        this.loadablesController = loadablesController;
    }

    @Override
    public void endRound(Game game) {
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
