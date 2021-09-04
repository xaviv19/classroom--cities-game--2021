package com.drpicox.game.testSteps.ship;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.ship.ShipTestView;
import org.springframework.stereotype.Component;

@Component
public class EnterNewShipNameStep extends AbstractPostLineStep {

    private final ShipTestView shipTestView;

    public EnterNewShipNameStep(ShipTestView shipTestView) {
        this.shipTestView = shipTestView;
    }

    @Override
    protected String getRegex() {
        return "Enter new ship name \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var newShipName = match[1];
        shipTestView.enterNewShipName(newShipName);
    }
}
