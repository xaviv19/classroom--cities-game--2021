package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.game.entities.EntityTestView;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import com.drpicox.game.testSteps.typeds.TypedTestView;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class YouShouldBeAtAnEmptyScreenStep extends AbstractPostLineStep {

    private final TypedTestView typedTestView;
    private final ScreenStackTestView screenStackTestView;
    private final EntityTestView entityTestView;

    public YouShouldBeAtAnEmptyScreenStep(TypedTestView typedTestView, ScreenStackTestView screenStackTestView, EntityTestView entityTestView) {
        this.typedTestView = typedTestView;
        this.screenStackTestView = screenStackTestView;
        this.entityTestView = entityTestView;
    }

    @Override
    protected String getRegex() {
        return "You should be at an empty screen";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var screenName = screenStackTestView.peekScreenName();
        var entityId = screenStackTestView.peekId();

        var entity = entityTestView.getEntity();
        assertThat(screenName).isEqualTo("entity");
        assertThat(entity).isNull();
    }
}
