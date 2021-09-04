package com.drpicox.game.testSteps.ship;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheLoadUnloadAmountShouldBeStep extends AbstractPostLineStep {


    private final ShipTestView shipTestView;

    public TheLoadUnloadAmountShouldBeStep(ShipTestView shipTestView) {
        this.shipTestView = shipTestView;
    }

    @Override
    protected String getRegex() {
        return "The load/unload amount should be (\\d+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var amount = Integer.parseInt(match[1]);

        var ship = shipTestView.getShip();
        assertThat(ship.getLoadUnloadAmount()).isEqualTo(amount);
    }
}
