package com.drpicox.game.testSteps.ship;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class ClickTheUnloadButtonStep extends AbstractPostLineStep {

    private final ShipTestView shipTestView;

    public ClickTheUnloadButtonStep(ShipTestView shipTestView) {
        this.shipTestView = shipTestView;
    }

    @Override
    protected String getRegex() {
        return "Click the unload button";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        shipTestView.submitUnload();
    }
}
