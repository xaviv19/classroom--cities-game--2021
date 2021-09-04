package com.drpicox.game.testSteps.ship;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.ship.ShipTestView;
import org.springframework.stereotype.Component;

@Component
public class ClickTheChangeShipNameButtonStep extends AbstractPostLineStep {

    private final ShipTestView shipTestView;

    public ClickTheChangeShipNameButtonStep(ShipTestView shipTestView) {
        this.shipTestView = shipTestView;
    }

    @Override
    protected String getRegex() {
        return "Click the change ship name button";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        shipTestView.submitChangeShipName();
    }
}
