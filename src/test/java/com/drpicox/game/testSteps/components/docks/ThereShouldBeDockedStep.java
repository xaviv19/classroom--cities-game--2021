package com.drpicox.game.testSteps.components.docks;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.locateds.LocatedTestView;
import org.springframework.stereotype.Component;

import static com.drpicox.game.testSteps.typeds.TypedTestView.byType;
import static com.drpicox.game.testSteps.owneds.OwnedTestView.byOwner;
import static com.google.common.truth.Truth8.assertThat;

@Component
public class ThereShouldBeDockedStep extends AbstractPostLineStep {


    private final LocatedTestView locatedTestView;

    public ThereShouldBeDockedStep(LocatedTestView locatedTestView) {
        this.locatedTestView = locatedTestView;
    }

    @Override
    protected String getRegex() {
        return "There should be (\\d+) docked \"([^\"]+)\" \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var expectedSize = Integer.parseInt(match[1]);
        var ownerName = match[2];
        var type = match[3];

        var ships = locatedTestView.streamCoLocateds().filter(byOwner(ownerName).and(byType(type)));
        assertThat(ships).hasSize(expectedSize);
    }
}
