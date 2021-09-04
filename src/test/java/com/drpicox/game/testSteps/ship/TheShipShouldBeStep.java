package com.drpicox.game.testSteps.ship;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.ship.ShipTestView;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheShipShouldBeStep extends AbstractPostLineStep {


    private final ShipTestView shipTestView;

    public TheShipShouldBeStep(ShipTestView shipTestView) {
        this.shipTestView = shipTestView;
    }

    @Override
    protected String getRegex() {
        return "The ship should be \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var shipName = match[1];

        var ship = shipTestView.getShip();
        assertThat(ship.getName()).isEqualTo(shipName);
    }
}
