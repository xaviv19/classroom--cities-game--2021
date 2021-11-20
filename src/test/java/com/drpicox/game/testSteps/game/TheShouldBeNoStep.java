package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.game.entities.EntityTestView;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheShouldBeNoStep extends AbstractPostLineStep {

    private final EntityTestView entityTestView;

    public TheShouldBeNoStep(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    @Override
    protected String getRegex() {
        return "There should be no _([^_]+)_";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var entityPropertyKey = PrettyKey.getKey(match[1]);

        var value = entityTestView.getEntity().get(entityPropertyKey);
        assertThat(value).isNull();
    }
}
