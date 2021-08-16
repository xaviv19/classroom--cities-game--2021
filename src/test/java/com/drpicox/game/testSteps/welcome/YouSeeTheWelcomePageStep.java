package com.drpicox.game.testSteps.welcome;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class YouSeeTheWelcomePageStep extends AbstractPostLineStep {

    @Override
    protected String getRegex() {
        return "You see the welcome page";
    }

    @Override
    protected void run(PostLine line, String[] match) {
    }
}
