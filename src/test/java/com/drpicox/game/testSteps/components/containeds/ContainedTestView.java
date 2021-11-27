package com.drpicox.game.testSteps.components.containeds;

import com.drpicox.game.testSteps.entities.EntityTestView;
import org.springframework.stereotype.Component;

@Component
public class ContainedTestView {
    private final EntityTestView entityTestView;

    public ContainedTestView(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    public String getContainerId() {
        return entityTestView.getEntity().get("containerId", String.class);
    }
}
