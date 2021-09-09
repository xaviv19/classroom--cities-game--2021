package com.drpicox.game.testSteps.docks;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.locateds.LocatedTestView;
import org.springframework.stereotype.Component;

import static com.drpicox.game.testSteps.game.TypedTestView.byType;
import static com.drpicox.game.testSteps.owneds.OwnedTestView.byOwner;
import static com.google.common.truth.Truth8.assertThat;

@Component
public class ThereShouldBeShipsStep extends AbstractPostLineStep {


    private final LocatedTestView locatedTestView;

    public ThereShouldBeShipsStep(LocatedTestView locatedTestView) {
        this.locatedTestView = locatedTestView;
    }

    @Override
    protected String getRegex() {
        return "There should be (\\d+) \"([^\"]+)\" ships";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var expectedSize = Integer.parseInt(match[1]);
        var ownerName = match[2];

        var ships = locatedTestView.streamCoLocateds().filter(byOwner(ownerName).and(byType("ship")));
        assertThat(ships).hasSize(expectedSize);
    }
}
