package com.drpicox.game.testSteps.components.docks;

import com.drpicox.game.testSteps.entities.EntityResponse;
import com.drpicox.game.testSteps.entities.EntityTestView;
import com.drpicox.game.testSteps.components.locateds.LocatedTestView;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Predicate;

@Component
public class DockTestView {
    public static Predicate<EntityResponse> isDock() {
        return e -> (Boolean) e.getOrDefault("isDock", Boolean.FALSE);
    }

    private final EntityTestView entityTestView;
    private final LocatedTestView locatedTestView;

    public DockTestView(EntityTestView entityTestView, LocatedTestView locatedTestView) {
        this.entityTestView = entityTestView;
        this.locatedTestView = locatedTestView;
    }

    public String getCoLocatedDockId() {
        return findCoLocatedDockId().orElseThrow(() -> {
            var entity = entityTestView.getEntity();
            var coLocateds = locatedTestView.streamCoLocateds().map(EntityTestView.toId());
            throw new AssertionError("Cannot find any dock at the location of the entity '"+entity.getId()+"' (loc: "+entity.get("location")+"). Other entities at that location are: "+coLocateds+".");
        });
    }

    public Optional<String> findCoLocatedDockId() {
        return locatedTestView.streamCoLocateds().filter(isDock()).findAny().map(e -> e.getId());
    }
}
