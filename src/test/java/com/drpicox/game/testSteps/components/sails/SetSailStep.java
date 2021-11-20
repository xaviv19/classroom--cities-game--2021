package com.drpicox.game.testSteps.components.sails;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class SetSailStep extends AbstractPostLineStep {

    private final SailTestView sailTestView;

    public SetSailStep(SailTestView sailTestView) {
        this.sailTestView = sailTestView;
    }

    @Override
    protected String getRegex() {
        return "Set sail";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        sailTestView.setSail();
    }
}
