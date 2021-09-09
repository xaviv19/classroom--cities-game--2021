package com.drpicox.game.components.loadables;

import com.drpicox.game.components.locateds.LocatedsController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EcsSystem;
import com.drpicox.game.games.Game;
import com.drpicox.game.components.populateds.PopulatedsController;
import org.springframework.stereotype.Component;

@Component
public class Sys100_LoadUnload implements EcsSystem {

    private final PopulatedsController populatedsController;
    private final LoadablesController loadablesController;
    private final LocatedsController locatedsController;
    private final TypedsController typedsController;

    public Sys100_LoadUnload(PopulatedsController populatedsController, LoadablesController loadablesController, LocatedsController locatedsController, TypedsController typedsController) {
        this.populatedsController = populatedsController;
        this.loadablesController = loadablesController;
        this.locatedsController = locatedsController;
        this.typedsController = typedsController;
    }

    @Override
    public void act(Game game) {
        var loadables = loadablesController.findAllByGame(game);
        loadables.forEach(loadable -> {
            var entityId = loadable.getEntityId();
            var loadUnloadAmount = loadable.getLoadUnloadAmount();
            if (loadUnloadAmount == 0) return;

            var targetId = getTargetId(game, entityId);
            var dockPopulation = populatedsController.getPopulation(targetId);

            loadUnloadAmount = Math.min(loadUnloadAmount, dockPopulation);
            var unfit = populatedsController.increasePopulation(entityId, loadUnloadAmount);
            loadablesController.clearLoadUnloadOrder(entityId);

            var delta = -(loadUnloadAmount - unfit);
            populatedsController.increasePopulation(targetId, delta);
        });

    }

    private String getTargetId(Game game, String entityId) {
        var myLocation = locatedsController.getLocation(entityId);
        var coLocateds = locatedsController.findByGameAndLocation(game, myLocation);
        var target = coLocateds.stream()
                .filter(l -> l.getLocation() == myLocation)
                .filter(l -> typedsController.isTyped(l.getEntityId(), "city"))
                .findFirst().get();

        return target.getEntityId();
    }
}
