package com.drpicox.game.testSteps.docks;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

@Component
public class ClickOnSeeTheDockStep extends AbstractPostLineStep {

    private final DockTestView dockTestView;
    private final ScreenStackTestView screenStackTestView;

    public ClickOnSeeTheDockStep(DockTestView dockTestView, ScreenStackTestView screenStackTestView) {
        this.dockTestView = dockTestView;
        this.screenStackTestView = screenStackTestView;
    }

    @Override
    protected String getRegex() {
        return "Click on see the dock";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var entityId = dockTestView.getCoLocatedDockId();

        screenStackTestView.pushScreenName("entity", entityId);
    }
}
