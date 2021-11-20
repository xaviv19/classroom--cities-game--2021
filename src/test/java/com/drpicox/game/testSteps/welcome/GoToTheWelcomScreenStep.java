package com.drpicox.game.testSteps.welcome;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

@Component
public class GoToTheWelcomScreenStep extends AbstractPostLineStep {

    private ScreenStackTestView screenStackTestView;

    public GoToTheWelcomScreenStep(ScreenStackTestView screenStackTestView) {
        this.screenStackTestView = screenStackTestView;
    }

    @Override
    protected String getRegex() {
        return "Go to the Welcome screen";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        screenStackTestView.pushScreenName("welcome");
    }
}
