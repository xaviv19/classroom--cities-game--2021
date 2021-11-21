package com.drpicox.game.testSteps.components.docks;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.entities.EntityTestView;
import com.drpicox.game.testSteps.components.locateds.LocatedTestView;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth8.assertThat;

@Component
public class ThereShouldBeDockedTheStep extends AbstractPostLineStep {

    private final LocatedTestView locatedTestView;

    public ThereShouldBeDockedTheStep(LocatedTestView locatedTestView) {
        this.locatedTestView = locatedTestView;
    }

    @Override
    protected String getRegex() {
        return "There should be docked the \"([^\"]+)\" \"([^\"]+)\" \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var ownerName = match[1];
        var entityName = match[2];
        var entityType = match[3];
        var expected = ownerName + "-" + entityName + "-" + entityType;

        var entities = locatedTestView.streamCoLocateds()
                .map(EntityTestView.toOwnerNameType());
        assertThat(entities).contains(expected);
    }
}
