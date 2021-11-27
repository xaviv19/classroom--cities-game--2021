package com.drpicox.game.testSteps.entities;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ThereShouldBeNoStep extends AbstractPostLineStep {

    private final EntityTestView entityTestView;

    public ThereShouldBeNoStep(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    @Override
    protected String getRegex() {
        return "There should be no _([^_]+)_";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var entityPropertyKey = PrettyKey.getKey(match[1]);

        var value = entityTestView.getEntity().containsKey(entityPropertyKey);
        assertThat(value).isFalse();
    }
}
