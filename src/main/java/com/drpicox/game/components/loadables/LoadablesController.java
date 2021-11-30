package com.drpicox.game.components.loadables;

import com.drpicox.game.components.resourceds.ResourcedsController;
import org.springframework.stereotype.Component;

@Component
public class LoadablesController {

    private final LoadablesRepository loadablesRepository;
    private final ResourcedsController resourcedsController;

    public LoadablesController(LoadablesRepository loadablesRepository, ResourcedsController resourcedsController) {
        this.loadablesRepository = loadablesRepository;
        this.resourcedsController = resourcedsController;
    }

    public Loadable create(String entityId) {
        var component = new Loadable(entityId);
        loadablesRepository.save(component);
        return component;
    }

    public void load(String loadableId, String dockId, String resource, int loadUnloadAmount) {
        resourcedsController.transfer(dockId, loadableId, resource, loadUnloadAmount);
    }

    public void unload(String loadableId, String dockId, String resource, int loadUnloadAmount) {
        resourcedsController.transfer(loadableId, dockId, resource, loadUnloadAmount);
    }
}
