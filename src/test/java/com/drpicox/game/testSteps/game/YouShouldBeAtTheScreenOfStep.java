package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import com.drpicox.game.typeds.TypedResponse;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class YouShouldBeAtTheScreenOfStep extends AbstractPostLineStep {

    private final NavigatorTestView navigatorTestView;
    private final EntityTestView entityTestView;

    public YouShouldBeAtTheScreenOfStep(NavigatorTestView navigatorTestView, EntityTestView entityTestView) {
        this.navigatorTestView = navigatorTestView;
        this.entityTestView = entityTestView;
    }

    @Override
    protected String getRegex() {
        return "You should be at the screen of a ([a-z ]+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var expectedScreenName = "entity";
        var expectedEntityType = match[1].trim();

        var screenName = navigatorTestView.peekScreenName();
        var entityType = entityTestView.getComponent(TypedResponse.class).getEntityType();

        assertThat(screenName).isEqualTo(expectedScreenName);
        assertThat(entityType).isEqualTo(expectedEntityType);
    }
}
