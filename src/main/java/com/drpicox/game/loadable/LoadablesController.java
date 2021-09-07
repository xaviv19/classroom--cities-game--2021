package com.drpicox.game.loadable;

import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public void changeLoadUnloadAmount(String entityId, int newLoadUnloadAmount) {
        var loadable = loadablesRepository.findById(entityId).get();
        loadable.changeLoadUnloadAmount(newLoadUnloadAmount);
        loadablesRepository.save(loadable);
    }

    public void clearLoadUnloadAmount(String entityId) {
        var loadable = loadablesRepository.findById(entityId).get();
        loadable.clearLoadUnloadAmount();
        loadablesRepository.save(loadable);
    }
}
