package com.drpicox.game.testSteps.populated;

import com.drpicox.game.testSteps.game.entities.EntityTestView;
import org.springframework.stereotype.Component;

@Component
public class PopulatedTestView {

    private final EntityTestView entityTestView;

    public PopulatedTestView(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    public int getPopulation() {
        return entityTestView.getEntityPropertyInt("population");
    }
}
