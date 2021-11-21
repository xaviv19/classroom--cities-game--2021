package com.drpicox.game.testSteps.components.docks;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth8.assertThat;

@Component
public class ItShouldNotBeDockedStep extends AbstractPostLineStep {

    private final DockTestView dockTestView;

    public ItShouldNotBeDockedStep(DockTestView dockTestView) {
        this.dockTestView = dockTestView;
    }

    @Override
    protected String getRegex() {
        return "It should not be docked";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var dockId = dockTestView.findCoLocatedDockId();
        assertThat(dockId).isEmpty();
    }
}
