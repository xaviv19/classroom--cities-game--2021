package com.drpicox.game.testSteps.components.docks;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

@Component
public class GoToSeeTheDockStep extends AbstractPostLineStep {

    private final DockTestView dockTestView;
    private final ScreenStackTestView screenStackTestView;

    public GoToSeeTheDockStep(DockTestView dockTestView, ScreenStackTestView screenStackTestView) {
        this.dockTestView = dockTestView;
        this.screenStackTestView = screenStackTestView;
    }

    @Override
    protected String getRegex() {
        return "Go to see the dock";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var entityId = dockTestView.getCoLocatedDockId();

        screenStackTestView.pushScreenName("entity", entityId);
    }
}
