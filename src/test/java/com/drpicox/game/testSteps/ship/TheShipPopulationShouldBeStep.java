package com.drpicox.game.testSteps.ship;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.ship.ShipTestView;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheShipPopulationShouldBeStep extends AbstractPostLineStep {


    private final ShipTestView shipTestView;

    public TheShipPopulationShouldBeStep(ShipTestView shipTestView) {
        this.shipTestView = shipTestView;
    }

    @Override
    protected String getRegex() {
        return "The ship population should be (\\d+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var expectedPopulation = Integer.parseInt(match[1]);

        var ship = shipTestView.getShip();
        assertThat(ship.getPopulation()).isEqualTo(expectedPopulation);
    }
}
