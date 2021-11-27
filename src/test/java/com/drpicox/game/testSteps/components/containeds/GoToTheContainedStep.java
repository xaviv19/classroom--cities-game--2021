package com.drpicox.game.testSteps.components.containeds;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

@Component
public class GoToTheContainedStep extends AbstractPostLineStep {

    private final ContainerTestView containerTestView;
    private final ScreenStackTestView screenStackTestView;

    public GoToTheContainedStep(ContainerTestView containerTestView, ScreenStackTestView screenStackTestView) {
        this.containerTestView = containerTestView;
        this.screenStackTestView = screenStackTestView;
    }

    @Override
    protected String getRegex() {
        return "Go to the contained \"([^\"]+)\" \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var type = match[1];
        var name = match[2];

        var contained = containerTestView.getContained(type, name);
        screenStackTestView.pushScreenName("entity", contained.getId());
    }
}
