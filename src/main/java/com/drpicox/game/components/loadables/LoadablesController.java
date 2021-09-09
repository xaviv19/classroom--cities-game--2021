package com.drpicox.game.components.loadables;

import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LoadablesController {

    private final LoadablesRepository loadablesRepository;

    public LoadablesController(LoadablesRepository loadablesRepository) {
        this.loadablesRepository = loadablesRepository;
    }

    public void create(String entityId, Game game) {
        var component = new Loadable(entityId, game);
        loadablesRepository.save(component);
    }

    public List<Loadable> findAllByGame(Game game) {
        return loadablesRepository.findAllByGame(game);
    }

    public void orderLoadUnload(String entityId, int newLoadUnloadAmount, String sourceEntityId) {
        var loadable = loadablesRepository.findById(entityId).get();
        loadable.orderLoadUnload(newLoadUnloadAmount, sourceEntityId);
        loadablesRepository.save(loadable);
    }

    public void clearLoadUnloadOrder(String entityId) {
        var loadable = loadablesRepository.findById(entityId).get();
        loadable.clearLoadUnloadOrder();
        loadablesRepository.save(loadable);
    }

    public Optional<Loadable> findById(String entityId) {
        return loadablesRepository.findById(entityId);
    }
}
