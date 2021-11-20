package com.drpicox.game.testSteps.screenStack;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class YouShouldBeAtTheScreenStep extends AbstractPostLineStep {

    private final ScreenStackTestView screenStackTestView;

    public YouShouldBeAtTheScreenStep(ScreenStackTestView screenStackTestView) {
        this.screenStackTestView = screenStackTestView;
    }

    @Override
    protected String getRegex() {
        return "You should be at the \"([^\"]+)\" screen";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var screenName = match[1];

        assertThat(screenStackTestView.peekScreenName()).isEqualTo(screenName);
    }
}
