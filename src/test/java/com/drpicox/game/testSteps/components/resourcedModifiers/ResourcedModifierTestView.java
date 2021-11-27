package com.drpicox.game.testSteps.components.resourcedModifiers;

import com.drpicox.game.testSteps.components.docks.DockTestView;
import com.drpicox.game.testSteps.entities.EntityTestView;
import com.drpicox.game.testSteps.game.GameTestView;
import org.springframework.stereotype.Component;

@Component
public class ResourcedModifierTestView {

    private final DockTestView dockTestView;
    private final GameTestView gameTestView;
    private final EntityTestView entityTestView;

    public ResourcedModifierTestView(DockTestView dockTestView, GameTestView gameTestView, EntityTestView entityTestView) {
        this.dockTestView = dockTestView;
        this.gameTestView = gameTestView;
        this.entityTestView = entityTestView;
    }

    public int getResourceModifierRoundIncrement(String resourceName) {
        checkResourceName(resourceName);

        return entityTestView.getEntity().getInt("modifierRoundIncrement");
    }

    public int getResourceModifierMaximum(String resourceName) {
        checkResourceName(resourceName);

        return entityTestView.getEntity().getInt("modifierMaximum");
    }

    private void checkResourceName(String resourceName) {
        var entity = entityTestView.getEntity();
        var actualResourceName = entity.getString("modifierResourceName");
        if (!actualResourceName.equals(resourceName)) throw entity.errorInEntity(
                "expected to have a modifier for the resource '"+ resourceName +"', " +
                        "but it had a modifier for the resource '"+actualResourceName+"'",
                "modifierResourceName"
        );
    }
}
