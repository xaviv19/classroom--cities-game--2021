package com.drpicox.game.testSteps.ship;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheShipShouldBeOfStep extends AbstractPostLineStep {


    private final ShipTestView shipTestView;

    public TheShipShouldBeOfStep(ShipTestView shipTestView) {
        this.shipTestView = shipTestView;
    }

    @Override
    protected String getRegex() {
        return "The ship should be of \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var ownerName = match[1];

        var ship = shipTestView.getShip();
        assertThat(ship.getOwnerName()).isEqualTo(ownerName);
    }
}
