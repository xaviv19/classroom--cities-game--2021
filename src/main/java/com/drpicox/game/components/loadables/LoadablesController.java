package com.drpicox.game.components.loadables;

import org.springframework.stereotype.Component;

@Component
public class LoadablesController {

    private final LoadablesRepository loadablesRepository;

    public LoadablesController(LoadablesRepository loadablesRepository) {
        this.loadablesRepository = loadablesRepository;
    }

    public void create(String entityId) {
        var component = new Loadable(entityId);
        loadablesRepository.save(component);
    }

    public Loadable orderLoad(String entityId, int loadAmount, String sourceEntityId) {
        var loadable = loadablesRepository.findById(entityId).get();
        loadable.orderLoadUnload(loadAmount, sourceEntityId);
        loadablesRepository.save(loadable);
        return loadable;
    }

    public Loadable orderUnload(String entityId, int loadAmount, String sourceEntityId) {
        var loadable = loadablesRepository.findById(entityId).get();
        loadable.orderLoadUnload(-loadAmount, sourceEntityId);
        loadablesRepository.save(loadable);
        return loadable;
    }
}
