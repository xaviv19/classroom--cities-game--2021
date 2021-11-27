package com.drpicox.game.testSteps.components.docks;

import com.drpicox.game.testSteps.components.locateds.LocatedTestView;
import com.drpicox.game.testSteps.entities.EntityResponse;
import com.drpicox.game.testSteps.entities.EntityTestView;
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
        return findCoLocatedDockId().orElseThrow(() -> errorNoDocksAtCurrentLocation());
    }

    public Optional<String> findCoLocatedDockId() {
        return locatedTestView.streamCoLocateds().filter(isDock()).findAny().map(e -> e.getId());
    }

    private AssertionError errorNoDocksAtCurrentLocation() {
        var entity = entityTestView.getEntity();
        var otherLocateds = locatedTestView.streamCoLocateds().findAny().isPresent();
        var coLocateds = locatedTestView.streamCoLocateds();
        return new AssertionError(
                "Cannot find any dock at the location of the entity " +
                        "'"+entity.getId()+"' (loc: "+entity.getOrDefault("location", "NO_LOCATION")+").\n" +
                        (
                                !otherLocateds
                                        ? "There are no other entities in the location"
                                        : "Other entities at that location are: "+
                                        coLocateds.map(e -> "\n- " + e.getId() + ", " + e.getOnwerNameType())
                        )

        );
    }
}
