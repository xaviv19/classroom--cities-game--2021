package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import com.drpicox.game.testSteps.typeds.TypedTestView;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class YouShouldBeAtTheScreenOfStep extends AbstractPostLineStep {

    private final TypedTestView typedTestView;
    private final ScreenStackTestView screenStackTestView;
    private final EntityTestView entityTestView;

    public YouShouldBeAtTheScreenOfStep(TypedTestView typedTestView, ScreenStackTestView screenStackTestView, EntityTestView entityTestView) {
        this.typedTestView = typedTestView;
        this.screenStackTestView = screenStackTestView;
        this.entityTestView = entityTestView;
    }

    @Override
    protected String getRegex() {
        return "You should be at the screen of a \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var expectedScreenName = "entity";
        var expectedType = match[1].trim();

        var screenName = screenStackTestView.peekScreenName();
        var type = typedTestView.getType();

        assertThat(screenName).isEqualTo(expectedScreenName);
        assertThat(type).isEqualTo(expectedType);
    }
}
