package com.drpicox.game.testSteps.screenStack;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ThereShouldNotBeABackButtonStep extends AbstractPostLineStep {

    private final ScreenStackTestView screenStackTestView;

    public ThereShouldNotBeABackButtonStep(ScreenStackTestView screenStackTestView) {
        this.screenStackTestView = screenStackTestView;
    }

    @Override
    protected String getRegex() {
        return "There should not be a back button";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var screenName = screenStackTestView.peekScreenName();

        assertThat(screenName).isAnyOf("game", "welcome", "login");
    }
}
