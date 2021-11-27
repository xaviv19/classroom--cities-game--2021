package com.drpicox.game.testSteps.components.docks;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.components.typeds.TypedTestView;
import com.drpicox.game.testSteps.components.nameds.NamedTestView;
import com.drpicox.game.testSteps.components.owneds.OwnedTestView;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ItShouldBeDockedAtTheStep extends AbstractPostLineStep {


    private final DockTestView dockTestView;
    private final OwnedTestView ownedTestView;
    private final TypedTestView typedTestView;
    private final NamedTestView namedTestView;

    public ItShouldBeDockedAtTheStep(DockTestView dockTestView, OwnedTestView ownedTestView, TypedTestView typedTestView, NamedTestView namedTestView) {
        this.dockTestView = dockTestView;
        this.ownedTestView = ownedTestView;
        this.typedTestView = typedTestView;
        this.namedTestView = namedTestView;
    }

    @Override
    protected String getRegex() {
        return "It should be docked at the \"([^\"]+)\" \"([^\"]+)\" \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var expectedOwnerName = match[1];
        var expectedType = match[2];
        var expectedName = match[3];

        var dockId = dockTestView.getCoLocatedDockId();
        var ownerName = ownedTestView.getEntityOwner(dockId);
        var type = typedTestView.getEntityType(dockId);
        var name = namedTestView.getEntityName(dockId);

        assertThat(ownerName).isEqualTo(expectedOwnerName);
        assertThat(type).isEqualTo(expectedType);
        assertThat(name).isEqualTo(expectedName);
    }
}
