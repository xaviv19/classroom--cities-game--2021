package com.drpicox.game.testSteps.ship;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheUnloadButtonShouldBeStep extends AbstractPostLineStep {


    private final ShipTestView shipTestView;

    public TheUnloadButtonShouldBeStep(ShipTestView shipTestView) {
        this.shipTestView = shipTestView;
    }

    @Override
    protected String getRegex() {
        return "The unload button should be (highlighted|normal)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var isRequested = match[1].equals("highlighted");

        var ship = shipTestView.getShip();
        assertThat(ship.isUnloadRequested()).isEqualTo(isRequested);
    }
}
