package com.drpicox.game.testSteps.newPlayer;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testViews.NewPlayerTestView;
import org.springframework.stereotype.Component;

@Component
public class SetYourPasswordStep extends AbstractPostLineStep {

    private NewPlayerTestView newPlayerTestView;

    public SetYourPasswordStep(NewPlayerTestView newPlayerTestView) {
        this.newPlayerTestView = newPlayerTestView;
    }

    @Override
    protected String getRegex() {
        return "Set your password";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        newPlayerTestView.setPassword("tbbt12");
    }
}
