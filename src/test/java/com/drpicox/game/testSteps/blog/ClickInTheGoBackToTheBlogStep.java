package com.drpicox.game.testSteps.blog;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

@Component
public class ClickInTheGoBackToTheBlogStep extends AbstractPostLineStep {

    private final ScreenStackTestView screenStackTestView;

    public ClickInTheGoBackToTheBlogStep(ScreenStackTestView screenStackTestView) {
        this.screenStackTestView = screenStackTestView;
    }

    @Override
    protected String getRegex() {
        return "Click in the go back to the blog";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        screenStackTestView.popScreenName();
    }
}
