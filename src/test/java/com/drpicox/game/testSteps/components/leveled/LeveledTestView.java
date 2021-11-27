package com.drpicox.game.testSteps.components.leveled;

import com.drpicox.game.testSteps.entities.EntityTestView;
import org.springframework.stereotype.Component;

@Component
public class LeveledTestView {

    private final EntityTestView entityTestView;

    public LeveledTestView(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    public void upgrade() {
        entityTestView.post("leveleds", "upgrade");
    }
}
