package com.drpicox.game.testSteps.components.sails;

import com.drpicox.game.testSteps.entities.EntityTestView;
import org.springframework.stereotype.Component;

@Component
public class SailTestView {

    private final EntityTestView entityTestView;

    public SailTestView(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    public void setSail() {
        entityTestView.post("sails", "sail");
    }

    public void haltSailing() {
        entityTestView.post("sails", "halt");
    }
}
