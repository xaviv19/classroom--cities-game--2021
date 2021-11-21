package com.drpicox.game.testSteps.components.docks;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.entities.EntityTestView;
import com.drpicox.game.testSteps.components.locateds.LocatedTestView;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth8.assertThat;

@Component
public class GoToSeeTheDockedStep extends AbstractPostLineStep {

    private final LocatedTestView locatedTestView;
    private final ScreenStackTestView screenStackTestView;

    public GoToSeeTheDockedStep(LocatedTestView locatedTestView, ScreenStackTestView screenStackTestView) {
        this.locatedTestView = locatedTestView;
        this.screenStackTestView = screenStackTestView;
    }

    @Override
    protected String getRegex() {
        return "Go to see the docked \"([^\"]+)\" \"([^\"]+)\" \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var owner = match[1];
        var type = match[2];
        var name = match[3];

        var list = locatedTestView.streamCoLocateds().map(EntityTestView.toOwnerNameType());
        assertThat(list).contains(owner + "-" + name + "-" + type);

        var docked = locatedTestView.streamCoLocateds()
                .filter(EntityTestView.byOwnerNameType(owner, name, type))
                .findFirst().get();

        screenStackTestView.pushScreenName("entity", docked.getId());
    }
}
