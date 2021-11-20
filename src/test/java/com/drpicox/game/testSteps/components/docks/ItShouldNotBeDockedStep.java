package com.drpicox.game.testSteps.components.docks;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.nameds.NamedTestView;
import com.drpicox.game.testSteps.owneds.OwnedTestView;
import com.drpicox.game.testSteps.typeds.TypedTestView;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth8.assertThat;

@Component
public class ItShouldNotBeDockedStep extends AbstractPostLineStep {


    private final DockTestView dockTestView;
    private final OwnedTestView ownedTestView;
    private final TypedTestView typedTestView;
    private final NamedTestView namedTestView;

    public ItShouldNotBeDockedStep(DockTestView dockTestView, OwnedTestView ownedTestView, TypedTestView typedTestView, NamedTestView namedTestView) {
        this.dockTestView = dockTestView;
        this.ownedTestView = ownedTestView;
        this.typedTestView = typedTestView;
        this.namedTestView = namedTestView;
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
