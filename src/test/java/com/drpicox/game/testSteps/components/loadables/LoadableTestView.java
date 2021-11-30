package com.drpicox.game.testSteps.components.loadables;

import com.drpicox.game.testSteps.components.docks.DockTestView;
import com.drpicox.game.testSteps.entities.EntityTestView;
import org.springframework.stereotype.Component;

@Component
public class LoadableTestView {

    private final DockTestView dockTestView;
    private final EntityTestView entityTestView;

    public LoadableTestView(DockTestView dockTestView, EntityTestView entityTestView) {
        this.dockTestView = dockTestView;
        this.entityTestView = entityTestView;
    }

    public void load(String resource) {
        var dockId = dockTestView.getCoLocatedDockId();
        entityTestView.putFormKey("resource", resource);
        entityTestView.putFormKey("dockId", dockId);
        entityTestView.post("loadables", "load");
    }

    public void unload(String resource) {
        var dockId = dockTestView.getCoLocatedDockId();
        entityTestView.putFormKey("resource", resource);
        entityTestView.putFormKey("dockId", dockId);
        entityTestView.post("loadables", "unload");
    }
}
